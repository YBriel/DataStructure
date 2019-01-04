package dailyTest;

/**
 * @author: yuzq
 * @Date: 2018-12-27  10:26
 * @Description:
 **/
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("你好！");
    }

    @Override
    public void sayHi() {
        System.out.println("hi");
    }
}
