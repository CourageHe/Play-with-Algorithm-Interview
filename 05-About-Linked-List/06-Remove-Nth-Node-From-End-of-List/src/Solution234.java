/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 234 https://leetcode-cn.com/problems/palindrome-linked-list/
 * @Autor:CourageHe
 * @Date: 2020/5/8 20:54
 */

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //偶数个
        if(fast != null)slow = slow.next;
        cutLinkedList(head,slow);
        slow = reverseLinkedList(slow);
        boolean result = equal(head, slow);
        return result;
    }
    //链表切割
    public static void cutLinkedList(ListNode head1,ListNode head2){
        ListNode node = head1;
        while(node.next != head2){
            node = node.next;
        }
        node.next = null;
    }
    //链表反转
    public static ListNode reverseLinkedList(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //链表比较
    public static boolean equal(ListNode head1,ListNode head2){
        boolean result = true;
        while(head1 != null && head2 != null){
            if(head1.val != head2.val) result = false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        int[]arr = {1,2,3,4};
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);

        Solution234 ss = new Solution234();
        boolean res= ss.isPalindrome(head);

        System.out.print("result：" + res);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}