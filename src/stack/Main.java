package stack;

import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack =new ArrayStack<Integer>();
        for(int i=0;i<5;i++){
            //往栈添加元素
            stack.push(i);
            System.out.println(stack);
        }
        //往栈取出元素
        stack.pop();
        System.out.println(stack);
    }

}
