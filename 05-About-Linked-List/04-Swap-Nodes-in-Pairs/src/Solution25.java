/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 25 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @Autor:CourageHe
 * @Date: 2020/5/5 20:54
 */

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head== null||head.next == null || k ==1)return head;
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        pre.next = head;

        while (head!=null){
            //计算剩余链表是否为k个
            int count = 0;
            ListNode index = head;
            while (index!= null){
                index = index.next;
                count++;
                if(count==k) break;
            }
            if(count == k){
               pre = reverseList(pre,head,count);
               head = pre.next;
            }else {
                break;
            }
        }
        return newHead.next;

    }
    public ListNode reverseList(ListNode pre, ListNode cur, int count) {
        while (count!=1){
            ListNode latter= cur.next;
            cur.next=latter.next;
            latter.next = pre.next;
            pre.next =latter;
            count--;
        }
        return cur;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]arr = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr);


        Solution25 ss = new Solution25();
        ListNode resHead = ss.reverseKGroup(head,2);
        resHead.toString();

        System.out.print("result：" + resHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
