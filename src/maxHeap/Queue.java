package maxHeap;

public interface Queue<E> {
    //    得到大小
    int getSize();

    //    判断是否为空
    boolean isEmpty();

    //    入队
    void enqueue(E e);

    //   删除
    E dequeue();

    //  取队
    E getFront();
}
