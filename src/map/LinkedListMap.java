package map;

/**
 * @author: yuzq
 * @Date: 2018-12-18  10:30
 * @Description:
 **/
public class LinkedListMap<K,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
        public Node(K key){
            this(key,null,null);

        }
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString()+value.toString();
        }
    }
    private Node dummyhead;
    private int size;

    private LinkedListMap(){
        dummyhead=new Node();
        size=0;
    }

    private Node getNode(K key){
        Node cur=dummyhead.next;
        while (cur!=null){
            if(cur.key.equals(key)){
                return cur;
            }else {
                cur=cur.next;
            }
        }return null;
    }


    @Override
    public void add(K key, V value) {
        Node node =getNode(key);
        if(node ==null){
            dummyhead.next=new Node(key,value,dummyhead.next);
            size++;
        }else {
            node.value=value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev=dummyhead;
        while (prev.next!=null){
            if(prev.next.key.equals(key)){
                break;
            }prev=prev.next;
        }
        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) !=null;
    }

    @Override
    public V get(K key) {
       Node node=getNode(key);
        return node==null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node=getNode(key);
        if(node==null){
            throw new IllegalArgumentException(key+"不存在！");

        }node.value=newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
