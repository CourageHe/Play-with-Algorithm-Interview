/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution83_2
 * @Description: leetcode 83 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @Autor:CourageHe
 * @Date: 2020/4/14 16:49
 */
public class Solution83_2 {
    //递归法
    public ListNode deleteDuplicates(ListNode head) {//前节点
        if(head == null || head.next == null) return head;
        ListNode next = deleteDuplicates(head.next);//下一节点（无重复）
        //返回的无重复next
        head.next = next;
        return head.val == next.val ? next : head;//去重
    }

    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        int []nums= {1,1,2};
        ListNode head = new ListNode(nums);

        Solution83_2 ss = new Solution83_2();
        ListNode newHead = ss.deleteDuplicates(head);

        System.out.print("result："+newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }


}
