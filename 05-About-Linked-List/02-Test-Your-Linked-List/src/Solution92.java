import java.awt.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution92
 * @Description: leetcode 92 https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *  编写了listnode的数据结构类，本地生成链表并打印
 * @Autor:CourageHe
 * @Date: 2020/4/14 15:56
 */
public class Solution92 {

    //虚拟头节点
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tail = null;
        for(int i =1;i<=n;i++){
            if(i < m) pre = pre.next;
            else if(i == m) tail = pre.next;
            else{
                ListNode next =  tail.next;
                tail.next = next.next;
                next.next = pre.next;
                pre.next  = next;
            }
        }
        return pre.val == -1?pre.next:head;
    }

    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        int []nums= {1,2,3,4,5};
        ListNode head = new ListNode(nums);

        Solution92 ss = new Solution92();
        ListNode newHead = ss.reverseBetween(head,2,4);

        System.out.print("result："+newHead);
        long endTime = System.currentTimeMillis();
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
