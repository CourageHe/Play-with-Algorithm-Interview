/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 206 https://leetcode-cn.com/problems/reverse-linked-list/
 * @Autor:CourageHe
 * @Date: 2020/4/4 19:19
 */



public class Solution206_2 {

    //头插法
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);//作为中转节点
        while(head!= null){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }

        return newHead.next;
    }


    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        int []nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
        Solution206_2 ss = new Solution206_2();
        ListNode res = ss.reverseList(head);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Solution run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
