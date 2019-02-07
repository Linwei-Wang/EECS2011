package A2;

import java.util.Stack;

public class Expression {
    public static boolean isOperator(char x) {
            if (x == '+'|| x == '-' || x == '*'||x=='/')
        return true;
            else return false;
  }
    public static boolean isBracket(char x) {
    	if (x == ')')
    		return true;
    	else return false;
    }
//   // public static void numOfRightBracket(char x) {
//    //    int i=0;
//    //    if (x == ')')
//    //    i++;
//  //  }
    public static String ExprTrans(String exp) {
        Stack<Character> a = new Stack<Character>();
        StringBuffer postfix = new StringBuffer(exp.length());
        int length = exp.length();
        String a1 = "";
        int number = 0;
        char c = 0 ;
        for (int i = 0; i < length;i++) {
        	c  = exp.charAt(i);
        	if (!isOperator(exp.charAt(i))) {
        		postfix.append(c);
//        	a.push(exp.charAt(i));
//        	a1 = ""+ a.pop();
        }
        	if (postfix.charAt(i) == ')') {
        		
        	}
        }
          
		return " " + postfix;
    }
    public static void main(String arg[]) {
        String exp = "a+20)/b-c)*53.4-d)))";
        System.out.println("" + ExprTrans(exp)); 
        System.out.println(exp.charAt(1));
    }
}