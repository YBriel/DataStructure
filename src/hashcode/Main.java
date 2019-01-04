package hashcode;

/**
 * @author: yuzq
 * @Date: 2018-12-27  14:43
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        int a=42;
        System.out.println(((Integer)a).hashCode());
        int b=-42;
        System.out.println(((Integer)b).hashCode());
    }
}
