package test;
/**
 * 测试出错，因为Array未写resize方法添加失败
 */

import LinkedListStack.LinkedListStack;
import stack.ArrayStack;
import stack.Stack;

import java.util.Random;

public class Main {
        private static double testStack(Stack<Integer> stack, int opCount){
//            获得系统时间的毫秒
            long startTime=System.nanoTime();
            Random random=new Random();
            for (int i=0;i<opCount;i++){
                stack.push(random.nextInt(Integer.MAX_VALUE));
            }
            for (int i=0;i<opCount;i++){
                stack.pop();
            }
            long endTime=System.nanoTime();
            return (endTime-startTime)/100000000.0;
        }
    public static void main(String[] args) {
        int opCount=100000;
        ArrayStack<Integer> arrayStack=new ArrayStack<Integer>();
        double time=testStack(arrayStack,opCount);
        System.out.println("time1的时间时候："+time+"s");
      //  LinkedListStack<Integer> linkedListStack=new LinkedListStack<Integer>();
       LinkedListStack<Integer> linkedListStack=new LinkedListStack<Integer>();
       testStack(linkedListStack,opCount);
        double time2=testStack(linkedListStack,opCount);
       System.out.println("time2的时间为:"+time2+"s");
    }
}
