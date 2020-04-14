/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution328
 * @Description: leetcode 328 https://leetcode-cn.com/problems/odd-even-linked-list/
 * @Autor:CourageHe
 * @Date: 2020/4/14 17:23
 */
public class Solution328 {

    //借助俩个虚拟头节点实现
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode lhead = new ListNode(-1);
        ListNode ltail = lhead;
        ListNode rhead = new ListNode(-1);
        ListNode rtail = rhead;
        for(int i =1;head != null;i++) {
            if (i%2 == 1) {
                ltail.next = head;
                ltail = ltail.next;
            } else {
                rtail.next = head;
                rtail = rtail.next;
            }
            head = head.next;
        }

        ltail.next = rhead.next;
        rtail.next = null;
        return lhead.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);

        System.out.println("origin:"+head);

        Solution328 ss = new Solution328();
        ListNode newHead = ss.oddEvenList(head);

        System.out.print("result：" + newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
