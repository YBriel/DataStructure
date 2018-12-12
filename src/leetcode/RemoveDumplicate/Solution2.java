package leetcode.RemoveDumplicate;

/**
 * @author: yuzq
 * @Date: 2018-12-12  14:23
 * @Description:203号
 **/
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;

        ListNode prev=dummyHead;
        while (prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }
        }return dummyHead.next;
    }
}