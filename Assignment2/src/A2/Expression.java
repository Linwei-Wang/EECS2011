package A2;
//Linwei-Wang

//EECS2011 Assignment2
import java.util.Stack;

public class Expression {
	public static boolean isOperator(char x) {
		if (x == '+' || x == '-' || x == '*' || x == '/')
			return true;
		else
			return false;
	}

	public static boolean isBracket(char x) {
		if (x == ')')
			return true;
		else
			return false;
	}

	public static String Transform(String expr) {
		Stack<String> stack = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		StringBuilder buf = null;
		String result = "";
		String result2 = "";

		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);

			if (isBracket(ch)) {
				if (buf != null) {
					stack.push(buf.insert(0, '(').append(')').toString());
					buf = null;
				} else if (stack.size() >= 2) {
					String b = stack.pop();
					String a = stack.pop();
					stack.push('(' + a + b + ')');
				}
			} else if (isOperator(ch) && buf == null && !stack.isEmpty())
				stack.push(stack.pop() + ch);
			else {
				if (buf == null)
					buf = new StringBuilder();
				buf = buf.append(ch);
			}
		}

		for (int i = 0; i < expr.length() - 1; i++) {
			char c = expr.charAt(i);

			if (!isOperator(c) && !isBracket(c))
				result2 += c;

			else if (isOperator(c))
				stack2.push(c);

			else if (isBracket(c)) {
				if (!stack2.isEmpty())
					result2 += stack2.pop();

			}
		}

		while (!stack2.isEmpty())
			result2 += stack2.pop();

		result = String.join("", stack);
		return "InFix : " + result + '\n' + "PostFix : " + result2;
	}

//	public static void main(String[] args) {
//		System.out.println("Input: a + 20 )/ b - c )* 53.4 - d )))");
//		System.out.println(Expression.Transform("a + 20 )/ b - c )* 53.4 - d )))"));
//		System.out.println("Input : a - 20 )* b - c )/ 53.4 - d )- a - b ))");
//		System.out.println(Expression.Transform("a - 20 )* b - c )/ 53.4 - d )- a - b ))"));
//		System.out.println("Input : a + 10 )/ b - 10 )");
//		System.out.println(Expression.Transform("a + 10 )/ b - 10 )"));
//	}
}