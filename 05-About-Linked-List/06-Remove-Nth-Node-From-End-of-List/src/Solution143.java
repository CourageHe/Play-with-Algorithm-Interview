/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 143 https://leetcode-cn.com/problems/reorder-list/
 * @Autor:CourageHe
 * @Date: 2020/5/8 20:54
 */

public class Solution143 {
    //链表分割 然后将第二☞链表反转
    //将两链表交叉插入
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        int total = getListLength(head);
        ListNode pre = head;
        //total%2 偶数为0 奇数为1
        for(int i =1;i<(total/2+total%2);i++){
            pre = pre.next;
        }
        ListNode head2 = reverseList(pre.next);
        pre.next = null;

        ListNode cur1 = head;
        ListNode latter1 = head.next;
        ListNode cur2 = head2;
        ListNode latter2 = head2.next;
        while (cur1 !=null&&cur2!=null){
            cur1.next = cur2;
            cur2.next=latter1;
            cur1 = latter1;
            cur2= latter2;
            if(latter1== null||latter2== null) break;
            latter1 = latter1.next;
            latter2= latter2.next;
        }
    }
    public int getListLength(ListNode head) {
        int total = 0;
        ListNode cur = head;
        while (cur!= null){
            cur = cur.next;
            total++;
        }
        return total;
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!= null){
            ListNode latter = cur.next;
            cur.next = pre;
            pre =cur;
            cur = latter;
        }
        return pre;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        int[]arr = {1,2,3,4};
        int[]arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr);

        Solution143 ss = new Solution143();
        ss.reorderList(head);

        System.out.print("result：" + head);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }

}
