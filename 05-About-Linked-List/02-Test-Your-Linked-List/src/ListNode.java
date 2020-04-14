/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ListNode
 * @Description: ListNode 数据结构
 * @Autor:CourageHe
 * @Date: 2020/4/14 15:31
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int x) { val = x; }

    //根据n个元素的数组arr创建一个链表
    //使用arr为参数，创建另外一个listnode的构造函数
    public ListNode(int []arr) {
        this.val = arr[0];
        ListNode last=this;
        for(int i = 1 ; i < arr.length ; i ++){
            last.next= new ListNode(arr[i]);
            last =  last.next;
        }
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder s = new StringBuilder("");
        while(cur!= null){
            s.append(cur.val);
            s.append(" --> ");
            cur = cur.next;
        }
        s.append("NULL\n");
        return s.toString();
    }


}
