/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution445
 * @Description: leetcode 445  https://leetcode-cn.com/problems/add-two-numbers-ii/
 * @Autor:CourageHe
 * @Date: 2020/4/14 21:19
 */
public class Solution445 {

    //综合206反转链表，2两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 =reverseList(l1);
        ListNode rl2 =reverseList(l2);
        ListNode head= new ListNode(-1);
        ListNode h = head;
        int carry = 0;
        while (rl1 != null ||rl2!= null ||carry != 0){
            if(rl1 == null) rl1 = new ListNode(0);
            if(rl2 == null) rl2 = new ListNode(0);

            int sum = rl1.val + rl2.val + carry;
            h.next=  new ListNode(sum%10);
            carry = sum/10;

            h = h.next;
            rl1  = rl1.next;
            rl2  = rl2.next;
        }

        return reverseList(head.next);
    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        head.next = null;
        next.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]nums1= {7,2,4,3};
        int[]nums2= {5,6,4};
        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);


        Solution445 ss = new Solution445();
        ListNode newHead = ss.addTwoNumbers(l1,l2);
//        ListNode newHead = ss.reverseList(l1);

        System.out.print("result：" + newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
