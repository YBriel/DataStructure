package recursion;

/**
 * @author: yuzq
 * @Date: 2018-12-12  14:38
 * @Description:
 **/
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }
//    计算arr[l....n)这个区间内所有的数字的和
    private static int sum(int[] arr,int l){
        if(l==arr.length){
            return 0;
        }else {
            return arr[l]+sum(arr,l+1);
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }
}
