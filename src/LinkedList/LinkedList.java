
package LinkedList;
//链表是增删改查的时间复杂度都是o(n)
//适合只对链表头进行操作
//yuzq 2018/12/12
import sun.org.mozilla.javascript.internal.ast.WhileLoop;

//链表的添加元素
public class LinkedList<E>{
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(E e){
//        Node node=new Node(e);
//        node.next=head;
//        head=node;
//        head=new Node(e,head);
//        size++;
        add(0,e);
    }
//    在链表Index（0-based)的位置添加新的元素e
    public void add(int index,E e){
       if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed,illegal index!");
        }
        /*if(index==0){
            addFirst(e);
        }*/
            Node prev=dummyHead;
            for(int i=0;i<index;i++){
                prev=prev.next;}
//            Node node=new Node(e);
//            node.next=prev.next;
//            prev.next=node;
            prev.next=new Node(e,prev.next);
            size++;

    }
    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed,illegal index!");
        }else {
            //索引为0开始遍历current当前节点
            Node cur=dummyHead.next;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }return cur.e;
        }

    }
    //获得第一个
    public E getFirst(){
        return get(0);
    }
//    获得最后一个节点
    public E getLaat(){
        return get(size-1);
    }
    public void set(int index, E e ){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed,illegal index!");
        }else {
            Node cur=dummyHead.next;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }cur.e=e;
        }
    }
//    是否包含元素e，查找元素
    public boolean contains(E e ){
        Node cur=dummyHead.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }cur=cur.next;
        }return false;
    }

//    链表元素的删除
    public E remove(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("delete failed,illegal index!");
        }else {
            Node prev=dummyHead;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
//            retNode是删除返回的元素
            Node retNode=prev.next;
            prev.next=retNode.next;
            retNode.next=null;
            size--;
            return retNode.e;
        }

    }
//    删除第一个元素
    public E removeFirst(){
       return remove(0);
    }
//    删除最后一个元素
    public E removeLast(){
        return  remove(size-1);
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
         /* Node cur=dummyHead.next;
      while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }*/
       for(Node cur=dummyHead.next;cur!=null;cur=cur.next){
           res.append(cur+"->");
        }
       res.append("NULL");
        return res.toString();
    }
}
