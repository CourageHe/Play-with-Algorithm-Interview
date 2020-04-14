import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution82
 * @Description: leetcode 82 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @Autor:CourageHe
 * @Date: 2020/4/14 22:51
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                ListNode temp = head.next;
                while (temp != null && head.val == temp.val)
                    temp = temp.next;//去重，直至下一个不同值的节点
                head = temp;//原 头节点指定想新的不同值，重新循环检验
            } else {
                //节点与下一节点不同时，则可纳入tail尾节点
                tail.next = head;
                tail = tail.next;
                head = head.next;
            }
        }
        tail.next = head;//补充后一个用于计较节点的 next节点
        return newHead.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]nums= {1,2,3,3,4,4,5};
        ListNode head = new ListNode(nums);

        Solution82 ss = new Solution82();
        ListNode newHead = ss.deleteDuplicates(head);

        System.out.print("result：" + newHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
