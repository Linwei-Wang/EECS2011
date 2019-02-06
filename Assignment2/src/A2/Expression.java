package A2;

import java.util.Stack;

public class Expression {
    public static boolean isOperator(char x) {
            if (x == '+'|| x == '-' || x == '*'||x=='/')
        return true;
            else return false;
    }
    public static void numOfRightBracket(char x) {
        int i=0;
        if (x == ')')
        i++;
    }
    public static String ExprTrans(String exp) {
        Stack<String> a = new Stack<String>();
        //Stack<String> num = new Stack<String>();
        int length = exp.length();
        int number = 0;
        for (int i = 0; i < length;i++) {
            //numOfRightBracket(exp.charAt(i));
            if (exp.charAt(i) == ')') {
                number++;
                String tmp = "(";
                a.push(tmp);
            }
            if (isOperator(exp.charAt(i))) {
                a.push(exp).charAt(i);
            }
            //else a.push(exp).charAt(i);
        }
        return " " + number + a.peek();
    }
    public static void main(String arg[]) {
        String exp = "a+20)/b-c)*53.4-d)))";
        System.out.println("" + ExprTrans(exp)); 
        System.out.println(isOperator(exp.charAt(3)));
    }
}