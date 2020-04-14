import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution92
 * @Description: leetcode 92 https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Autor:CourageHe
 * @Date: 2020/4/4 23:36
 */

public class Solution92 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index= 1;
        ListNode cur = head;
        ListNode pre = null;
        ListNode tail = null;
        ListNode tempCur = null;
        ListNode tempPre = null;
        ListNode temptail = null;
        while(cur != null){
            if(index == m-1) pre = cur;
            if(index == m) tempCur = cur;
            if(index == n+1) tail = cur;
            cur = cur.next;
            index++;
        }

        tempPre = reverseList(tempCur,n-m+1);
        tempCur =tempPre;
        while (tempCur!=null){
            temptail = tempCur;
            tempCur = tempCur.next;
        }
        if(pre == null)head = tempPre;
        else pre.next = tempPre;
        temptail.next = tail;
        return head;
    }
    public ListNode reverseList(ListNode head,int opacity) {
        int index= 1;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null&&index <= opacity){
            ListNode tail = cur.next;

            cur.next = pre;
            pre = cur;
            cur = tail;
            index++;

        }
        return pre;
    }
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tail = head;
        for(int i =1;i<=n;i++){
            if(i<m) pre = pre.next;
            else if(i==m) tail = pre.next;
            else{
                ListNode temp = tail.next;
                tail.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return pre.val == -1?pre.next:head;
    }


        static ListNode generateLinkedList(int []nums){
        ListNode head = new ListNode(-1);
        ListNode last=head;
        for(int num :nums){
           ListNode node = new ListNode(num);
           last.next = node;
           last = node;
        }
        return head.next;
    }
    static void printLinkedList(ListNode head){
        ListNode cur = head;
        while(cur!= null){
            System.out.print(cur.val);
            if(cur.next!=null)
                System.out.print(" --> ");
            cur = cur.next;
        }
        System.out.println();

    }

    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
//        int []nums= {1,2,3,4,5};
        int []nums= {3,5};
        ListNode head = generateLinkedList(nums);

        Solution92 ss = new Solution92();
        ListNode newHead = ss.reverseBetween1(head,1,2);

        System.out.print("result：");
        printLinkedList(newHead);
        long endTime = System.currentTimeMillis();
        System.out.println("Two Sum run completely");
        System.out.println("Time cost:"+ (endTime - startTime)+"ms");
    }
}
