/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 237 https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @Autor:CourageHe
 * @Date: 2020/5/5 20:54
 */

public class Solution237 {
    //给定一个链表
    private static int[]arr = {4,5,1,9};
    private static ListNode  head = new ListNode(arr);

    // node表示的是要删除的结点
    public static void deleteNode(ListNode node) {
        // 因为无法访问前一个结点，所以可以把要删除的结点的后一个结点的值前移
        node.val = node.next.val;
        // 然后删除掉后一个结点
        node.next= node.next.next;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ListNode node = head.next;

        Solution237 ss = new Solution237();
        ss.deleteNode(node);

        System.out.print("result：" + head);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }
}
