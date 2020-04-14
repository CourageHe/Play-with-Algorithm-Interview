/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 203 https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @Autor:CourageHe
 * @Date: 2020/4/14 22:12
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        tail.next =head;
        while(head != null){
            if(head.val == val)
                tail.next = head.next;
            else
                tail = tail.next;
            head = head.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]nums= {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);


        Solution ss = new Solution();
        ListNode newHead = ss.removeElements(head,6);

        System.out.print("result：" + newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
