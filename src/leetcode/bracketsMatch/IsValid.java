package leetcode.bracketsMatch;

//leetcode括号匹配问题
import java.util.Stack;

public class IsValid {
    public boolean isvalid(String s){
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                 char topChar=stack.pop();
                if(c == ')' && topChar !='('){
                    return false;
                }if(c==']' && topChar !='['){
                    return false;
                }if (c=='}' && topChar!='{'){
                    return false;
                }
            }

        } return stack.isEmpty();
     }

    public static void main(String[] args) {
        IsValid is=new IsValid();
        if(is.isvalid("[{}]}")){
            System.out.println("匹配成功！");
        }else {
            System.out.println("匹配失败！");
        }

    }
}
