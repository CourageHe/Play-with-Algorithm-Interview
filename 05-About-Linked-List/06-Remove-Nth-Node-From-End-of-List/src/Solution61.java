/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 61 https://leetcode-cn.com/problems/rotate-list/
 * @Autor:CourageHe
 * @Date: 2020/5/8 20:54
 */

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)return head;
       //计算节点总数
        int total = 0;
        ListNode cur = head;
        while (cur != null){
            cur= cur.next;
            total++;
        }
        //k为整数倍的话可直接返回，即不用循环
        if((k%total) == 0)return head;
        //计算分割的节点位置
        int n = total-(k%total);
        ListNode pre = head,newHead=null;
        int index = 0;
        while (pre.next!=null){
            index++;
            if(index == n){
                newHead = pre.next;
                pre.next=null;
                break;
            }else {
                pre= pre.next;
            }
        }
        cur = newHead;
        while (cur.next!=null) cur = cur.next;
        cur.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]arr = {0,1,2};
        ListNode head = new ListNode(arr);

        Solution61 ss = new Solution61();
        ListNode resHead = ss.rotateRight(head,3);

        System.out.print("result：" + resHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }

}
