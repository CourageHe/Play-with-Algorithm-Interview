/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Solution98
 * @Description: leetcode 19 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * @Autor:CourageHe
 * @Date: 2020/5/7 20:54
 */

public class Solution19 {
    //采用递归遍历 回溯至第倒N+1个节点进行删除
    int total = 0;//节点总数
    int index=0;//递归坐标
    int Nth = 0;//被删除的n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head== null||n==0)return head;
        //虚拟头节点(当被删除的为第一个时，需用到前驱节点)
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next= head;
        Nth = n;
        removeNthHelper(dummyNode);
        return dummyNode.next;
    }
    private void removeNthHelper(ListNode head) {
        if(head== null){
            index=total+1;
            return;
        }
        total++;//计算节点总数
        ListNode cur = head.next;
        removeNthHelper(cur);
        index--;//递归坐标
        if((index+Nth)==total){//定位至被删节点的前一位
            head.next= cur.next;
        }
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[]arr = {4,5,1,9};
        ListNode  head = new ListNode(arr);

        Solution19 ss = new Solution19();
        ListNode resHead = ss.removeNthFromEnd(head,4);

        System.out.print("result：" + resHead);
        long endTime = System.currentTimeMillis();
        System.out.println(" solution run completely");
        System.out.println("Time cost:" + (endTime - startTime) + "ms");
    }

}
