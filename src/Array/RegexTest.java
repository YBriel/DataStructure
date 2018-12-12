package Array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        //var patt1 =/^(([1-9][0-9]*)|([0]\.\d{1,2})|([1-9][0-9]*\.\d{1,2}))$/;//正则表达式
      //  String reg="[1-9]*";
        String reg="/^(([1-9][0-9]*)|([0]\\.\\d{1,2})|([1-9][0-9]*\\.\\d{1,2}))$/";
       String reg1="(([1-9][0-9]*)|([0]\\.\\d{1,2})|([1-9][0-9]*\\.\\d{1,2}))";
        String s="6ss6";
        String s1="ss";
        String s2="66.66";
        Pattern pattern=Pattern.compile(reg1);
        Matcher matcher=pattern.matcher(s);
        Matcher matcher1=pattern.matcher(s1);
        Matcher matcher2=pattern.matcher(s2);
        boolean rs=matcher.matches();
        boolean rs1=matcher1.matches();
        boolean rs2=matcher2.matches();
        System.out.println("s的匹配结果是："+rs);
        System.out.println("s1的匹配结果是："+rs);
        System.out.println("s2的匹配结果是："+rs);
    }
}
