/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 148 https://leetcode-cn.com/problems/sort-list/
 * @Autor:CourageHe
 * @Date: 2020/5/7 20:54
 */

public class Solution148 {
    // O(n log n) 时间复杂度和常数级空间复杂度
    //满足O(nlogn)的排序算法有 归并排序、快速排序
    public ListNode sortList(ListNode head) {
        if(head== null||head.next == null )return head;
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head.next == null )return head;
        //快慢指针发找出链表的中点，并切断
        ListNode slow=head,fast=head,pre=null;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);

        return merge(l,r);
    }
    public ListNode merge(ListNode l,ListNode r) {
        //合并两个链表
        ListNode dummyNode= new ListNode(-1);
        ListNode cur = dummyNode;
        while (l!=null&&r!=null){
            if(l.val<=r.val){//归并排序是稳定的
                cur.next=l;
                cur=cur.next;
                l=l.next;
            }else {
                cur.next=r;
                cur=cur.next;
                r=r.next;
            }
        }
        while (l!=null){
            cur.next=l;
            cur=cur.next;
            l=l.next;
        }
        while (r!=null){
            cur.next=r;
            cur=cur.next;
            r=r.next;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]arr = {4,2,1,3,5,3};
        ListNode head = new ListNode(arr);

        Solution148 ss = new Solution148();
        ListNode resHead = ss.sortList(head);
        resHead.toString();

        System.out.print("result：" + resHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
