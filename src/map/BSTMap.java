package map;

/**
 * @author: yuzq
 * @Date: 2018-12-18  11:07
 * @Description:
 **/
public class BSTMap<K extends Comparable<K>,V>  implements Map<K,V>{
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;

    public BSTMap(){
        root=null;
        size=0;
    }
    @Override
    public void add(K key, V value) {
        root=add(root,key,value);
    }
    private Node add(Node node,K key,V value){
        if(node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else if(key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else {
            node.value=value;
        }
        return node;
    }

    private Node getNode(Node node,K key){
        if(node==null){
            return null;
        }if(key.compareTo(node.key)==0){
            return node;
        }else if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }
    }

    @Override
    public V remove(K key) {
        Node node=getNode(root,key);
        if(node !=null){
            root =remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }
        else if(key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }else {
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            Node successor=minum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
    }


    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(root,key);
        return node==null? null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node=getNode(root,key);
        if(node==null){
            throw new IllegalArgumentException(key+"不存在！");
        }node.value=newValue;
    }
    private Node minum(Node node){
        if(node.left==null){
            return node;
        }return minum(node.left);
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
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