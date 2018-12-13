package binarysearchtree;

/**
 * @author: yuzq
 * @Date: 2018-12-13  11:17
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst=new BST<Integer>();
        int[] nums={4,5,2,3,7,5};
        for(int num:nums){
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        System.out.println(bst);
    }
}
