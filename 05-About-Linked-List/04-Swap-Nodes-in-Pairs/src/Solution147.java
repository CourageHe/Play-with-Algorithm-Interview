/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 147 https://leetcode-cn.com/problems/insertion-sort-list/
 * @Autor:CourageHe
 * @Date: 2020/5/6 20:54
 */

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head== null||head.next == null )return head;
        ListNode newHead= new ListNode(-1);
        ListNode pre = newHead;
        pre.next = head;
        while (head!=null&&head.next!=null) {
            if(head.val<=head.next.val){
                head=head.next;
                continue;
            }
            while (pre.next.val<=head.next.val) pre=pre.next;
            ListNode temp = head.next.next;
            head.next.next= pre.next;
            pre.next= head.next;
            head.next= temp;

            pre=newHead;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]arr = {4,2,1,3};
        ListNode head = new ListNode(arr);

        Solution147 ss = new Solution147();
        ListNode resHead = ss.insertionSortList(head);
        resHead.toString();

        System.out.print("result：" + resHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
