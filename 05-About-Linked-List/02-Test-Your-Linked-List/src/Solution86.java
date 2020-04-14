/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution86
 * @Description: leetcode 86 https://leetcode-cn.com/problems/partition-list/
 * @Autor:CourageHe
 * @Date: 2020/4/14 16:53
 */
public class Solution86 {

    //借助俩个虚拟头节点实现
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode lhead = new ListNode(-1);
        ListNode ltail = lhead;
        ListNode rhead = new ListNode(-1);
        ListNode rtail = rhead;
        while (head != null) {
            if (head.val < x) {
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
        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(nums);

        Solution86 ss = new Solution86();
        ListNode newHead = ss.partition(head, 3);

        System.out.print("result：" + newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
