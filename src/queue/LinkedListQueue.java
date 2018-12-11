package queue;

public class LinkedListQueue<E> implements Queue<E> {

    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        public String toString() {
            return e.toString();
        }

    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail=null;
        size=0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head=tail;
        }else {
            tail.next=new Node(e);
            tail=tail.next;
        }size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("can not delete from a empty queue");
        }
        Node retNode=head;
        head=head.next;
        retNode.next=null;
        if(head==null){
            tail=null;
        }size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("can not delete from a empty queue");

        }
        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Queue:front");
        Node cur=head;
        while (cur!=null){
            sb.append(cur+"->");
            cur=cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }

}
