package segment;

/**
 * @author: yuzq
 * @Date: 2018-12-21  11:13
 * @Description:
 **/
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;
    public SegmentTree(E [] arr,Merger<E> merger){
        this.merger=merger;
    for(int i=0;i<arr.length;i++){
        data[i]=arr[i];
        tree =(E[])new Object[4*arr.length];
        buildSegmentTree(0,0,data.length-1);
    }

    }
    public void buildSegmentTree(int treeIndex,int l,int r){
        if(l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);
        int mid=l+(r-l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);
        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }
    public int getSize(){
        return data.length;
    }
    public E get(int index){
        if(index<0 || index>=data.length){
            throw new IllegalArgumentException("index is illegal!");
        }
        return data[index];
    }
    public int leftChild(int index){
        return 2*index + 1;
    }
    public int rightChild(int index){
        return 2*index+2;
    }
}
