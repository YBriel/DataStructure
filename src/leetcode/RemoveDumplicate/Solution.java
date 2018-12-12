package leetcode.RemoveDumplicate;

/**
 * @author: yuzq
 * @Date: 2018-12-12  14:09
 * @Description:
 **/
public class Solution {
    public ListNode removeElements(ListNode head,int val){
//        删除链表最前面的部分
        while (head!=null && head.val==val){
            ListNode delNode=head;
            head=head.next;
            delNode.next=null;
        }
        if(head==null){
            return null;
        }
        ListNode prev=head;
        while (prev.next !=null ){
            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return head;
    }
}
