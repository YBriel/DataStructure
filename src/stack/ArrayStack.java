package stack;

public class ArrayStack<E> implements Stack<E> {
  Array<E> array;
  //构造函数，传capacity
  public ArrayStack(int capacity){
      array = new Array<E>(capacity);
  }
  //默认大小
  public ArrayStack(){
      array=new Array<E>();
  }
  //实现接口中方法
  @Override
    public int getSize(){
      return array.getSize();
  }
  @Override
    public boolean isEmpty(){
      return array.isEmpty();
  }
    //底层实现是静态数组，stack是和栈实现无关
    public int getCapacity(){
      return array.getCapacity();
  }
  @Override
    public void push(E e){
      array.addLast(e);
  }
  @Override
    public E pop(){
      return array.removeLast();
  }
  @Override
    public E peek(){
        return array.getLast();
  }
  @Override
    public String toString(){
      StringBuilder res=new StringBuilder();
      res.append("Stack： ");
      res.append('[');
      for(int i=0;i<array.getSize();i++ ){
          res.append(array.get(i));
          if(i !=array.getSize()-1){
              res.append(',');
          }
      }res.append("] top");
      return res.toString();
  }

}
