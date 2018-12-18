package set;

import java.util.LinkedList;
import java.util.Queue;

/*
*
 * @author: yuzq
 * @Date: 2018-12-12  16:22
 * @Description:
 *
*/
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;
//        二分搜索树构造函数
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
//    二分搜索树成员变量
    private Node root;
    private int size;

    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }


   public void add(E e){
       root = add(root, e);
   }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e){

        if(node == null)
            return false;
        //e和node.e不是基础类型，所以只能使用compareTo
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }
//    前序遍历
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder sb){
        if(node==null){
            sb.append(generateBSTString(depth)+"null\n");
        }else {
            sb.append(generateBSTString(depth)+node.e+"\n");
            generateBSTString(node.left,depth+1,sb);
            generateBSTString(node.right,depth+1,sb);
        }
    }
//    中序遍历是排序后的结果
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    public String generateBSTString(int depth){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<depth;i++){
            sb.append("--");
        }return sb.toString();
    }
    //后序遍历
    public void postOrder(){
    postOrder(root);
    }
    public void postOrder(Node node){
        if(node==null){
            return;
        }else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }
//    层序遍历
    public void levelOrder(){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur= queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }
//删除最小值
    public E miniNum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty!");
        }return miniNum(root).e;
    }
    private Node miniNum(Node node){
        if(node.left==null){
            return node;
        }return node.left;
    }
//删除最大值
    public E maxNum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty!");
        }return maxNum(root).e;
    }
    private Node maxNum(Node node){
        if(node.right==null){
            return node;
        }return node.right;
    }
//    删除最小值所在的节点
    public E removeMin(){
        E ret=miniNum();
        removeMin(root);
        return ret;
    }
//    删除以node为根的二分搜索树中的最大节点
//    返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode=node.right;
            node.left=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }
    //    删除最小值所在的节点
    public E removeMax(){
        E ret=maxNum();
        removeMax(root);
        return ret;
    }
    //    删除以node为根的二分搜索树中的最大节点
//    返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode=node.left;
            node.right=null;
            size--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }
//Hibbard deletion
    public void remove(E e){

    }

    private Node remove(Node node, E e){
        if(node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }else if(e.compareTo(e)>0){
            node.right=remove(node.right,e);
            return node;
        }
        else {
//            待删除节点左子树为空的情况
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node lefrNode=node.left;
                node.left=null;
                size--;
                return lefrNode;
            }
//            均不为空的情况
            Node successor=miniNum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.right=node.left=null;
            return successor;
        }
    }
}
