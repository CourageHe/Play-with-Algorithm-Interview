/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution21
 * @Description: leetcode 21 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Autor:CourageHe
 * @Date: 2020/4/14 23:29
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null || l2 != null) {
            if(l1 == null){
                tail.next =l2;
                break;
            }else if(l2 == null){
                tail.next =l1;
                break;
            }
            if(l1.val<l2.val){
                tail.next = l1;
                tail= tail.next;
                l1=l1.next;
            }else {
                tail.next = l2;
                tail= tail.next;
                l2=l2.next;
            }
        }
        return head.next;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]nums1= {1,2,3,4,5,6};
        int[]nums2= {1,2,3,4,5,6};
        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);


        Solution21 ss = new Solution21();
        ListNode newHead = ss.mergeTwoLists(l1,l2);

        System.out.print("result：" + newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }


}
