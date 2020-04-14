/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution
 * @Description: leetcode 206 https://leetcode-cn.com/problems/reverse-linked-list/
 * @Autor:CourageHe
 * @Date: 2020/4/4 19:19
 */



public class Solution206_3 {


    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode cur =head;
        while(cur!= null){
            ListNode latter =cur.next;
            cur.next = pre;
            pre = cur;
            cur = latter;
        }
        return pre;
    }



    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        int []nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
        Solution206_3 ss = new Solution206_3();
        ListNode res = ss.reverseList(head);

        long endTime = System.currentTimeMillis();
        System.out.println("result："+res);
        System.out.println("Solution run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
