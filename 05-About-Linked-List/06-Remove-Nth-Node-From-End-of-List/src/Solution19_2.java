/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 19 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * @Autor:CourageHe
 * @Date: 2020/5/7 20:54
 */

public class Solution19_2 {


    //双指针法至窗口
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head== null||n==0)return head;
        //虚拟头节点(当被删除的为第一个时，需用到前驱节点)
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next= head;
        //双指针 先将两指针距离相隔n+1个，指针q为倒第n个节点的前驱
        ListNode p = dummyNode,q=dummyNode;
        for(int i =0;i<=n;i++)p = p.next;

        //窗口移动，直至移至末尾
        while (p!=null){
            p=p.next;
            q=q.next;
        }

        //此时q指针便是倒第n个节点的前驱
        q.next = q.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]arr = {4,5,1,9};
        ListNode  head = new ListNode(arr);

        Solution19_2 ss = new Solution19_2();
        ListNode resHead = ss.removeNthFromEnd(head,1);

        System.out.print("result：" + resHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }

}
