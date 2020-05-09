
/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 24 https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * @Autor:CourageHe
 * @Date: 2020/5/5 20:54
 */

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head== null||head.next == null)return head;
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        while (head != null && head.next !=null){
            ListNode temp = head.next.next;

            node.next = head.next;
            node.next.next = head;

            node = node.next.next;
            head=temp;

        }
        node.next = head;
        return newHead.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]arr = {1,2,3,4};
        ListNode head = new ListNode(arr);


        Solution24 ss = new Solution24();
        ListNode resHead = ss.swapPairs(head);
        resHead.toString();

        System.out.print("result：" + resHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
