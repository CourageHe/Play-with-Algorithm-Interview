import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 206 https://leetcode-cn.com/problems/reverse-linked-list/
 * @Autor:CourageHe
 * @Date: 2020/4/4 19:19
 */



public class Solution {

    //递归法
    public ListNode reverseList(ListNode head) {
        if(head == null||head.next == null)return head;

        ListNode next =head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        int []nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
        Solution ss = new Solution();
        ListNode res = ss.reverseList(head);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Solution run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
