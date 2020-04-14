/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution83
 * @Description: leetcode 83 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @Autor:CourageHe
 * @Date: 2020/4/14 16:39
 */
public class Solution83 {

    //普通法
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ||head.next == null) return head;
        ListNode cur = head;
        while(cur.next != null){
            ListNode next = cur.next;
            if(next.val == cur.val) cur.next = next.next;
            else cur = next;
        }
        return head;
    }


    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        int []nums= {1,1,2};
        ListNode head = new ListNode(nums);

        Solution83 ss = new Solution83();
        ListNode newHead = ss.deleteDuplicates(head);

        System.out.print("result："+newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
