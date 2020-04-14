/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution2
 * @Description: leetcode 2 https://leetcode-cn.com/problems/add-two-numbers/
 * @Autor:CourageHe
 * @Date: 2020/4/14 17:37
 */
public class Solution2 {
    //虚拟头节点法
    //时间复杂度O(n)
    //空间复杂度O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode h = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null  ) l1 = new ListNode(0);
            if (l2 == null  ) l2 = new ListNode(0);

            int sum = l1.val + l2.val + carry;
            h.next = new ListNode(sum % 10);
            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
            h = h.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]nums1= {5};
        int[]nums2= {5};
        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);


        Solution2 ss = new Solution2();
        ListNode newHead = ss.addTwoNumbers(l1,l2);

        System.out.print("result：" + newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}