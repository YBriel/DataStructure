package maxHeap;

/**
 * @author: yuzq
 * @Date: 2018-12-19  16:28
 * @Description:
 **/
public class MaxHeap<E extends Comparable<E>>  {
    private Array<E> data;
    public MaxHeap(int capacity){
        data=new Array<E>(capacity);
    }
    public MaxHeap(){
        data=new Array<E>();
    }
    public MaxHeap(E[] arr){
        data=new Array<E>(arr);
        for (int i=parent(arr.length-1);i>=0;i++){
            siftDown(i);
        }
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index==0){
            throw new IllegalArgumentException("index doesn't exist!");
        }return (index-1)/2;
    }
    private int leftChild(int index){
        return index*2+1;
    }
    private int rightChild(int index){
        return index*2+2;
    }
    //添加元素，堆叫sift up堆中元素上浮。
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }
    public void siftUp(int k){
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))>0){
            data.swap(k,parent(k));
            k=parent(k);
        }
    }
    public E findMax(){
        if(data.getSize()==0){
            throw new IllegalArgumentException("can not findMax when the heap is empty!"); }
        return data.get(0);
    }
    //取出堆中最大元素,数据下沉
    public E extractMax(){
        E ret=findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while(leftChild(k)<data.getSize()){
            int j=leftChild(k);
            if(j+1<data.getSize() && data.get(j+1).compareTo(data.get(j))>0){
                j=rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }data.swap(k,j);
            k=j;
        }
    }
//    取出最大的元素，并且替换成元素e
    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
    //heapify将任意数组整理成堆的形状

}
