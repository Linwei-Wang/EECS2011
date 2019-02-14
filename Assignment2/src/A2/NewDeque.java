package A2;
//Linwei-Wang

//EECS2011 Assignment2
import java.util.Stack;

public class NewDeque implements Deque<Object> {
	Stack<Object> a = new Stack<>();
	Stack<Object> b = new Stack<>();
	static NewDeque c;
	int i = 0;

	@Override
	public int size() {
		while (!a.empty() || !b.empty()) {
			if (a.empty()) {
				b.pop();
				i++;
				// i = b.capacity();
			} else {
				a.pop();
				i++;
//				i = a.capacity();
			}
		}
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public boolean isEmpty() {
		if (a.empty() && b.empty())
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object first() {
		if (a.empty() && b.empty())
			return null;
//		while (!a.empty()){
//			b.push(a.pop());
//		}
		while (!a.empty()) {
			b.push(a.pop());
		}

		// TODO Auto-generated method stub
		return b.peek();
	}

	@Override
	public Object last() {
		if (a.empty() && b.empty())
			return null;
		while (!b.empty()) {
			a.push(b.pop());
		}
		// TODO Auto-generated method stub
		return a.peek();
	}

	@Override
	public void addFirst(Object e) {
		while (!a.empty()) {
			b.push(a.pop());
		}
		// TODO Auto-generated method stub
		a.push(e);
	}

	@Override
	public void addLast(Object e) {

		while (!b.empty()) {
			a.push(b.pop());
		}
		// TODO Auto-generated method stub
		b.push(e);
	}

	@Override
	public Object removeFirst() {
		if (a.empty() && b.empty())
			return null;
		while (!a.empty()) {
			b.push(a.pop());
		}
		// TODO Auto-generated method stub
		return b.pop();
	}

	@Override
	public Object removeLast() {
		if (a.empty() && b.empty())
			return null;
		while (!b.empty()) {
			a.push(b.pop());
		}
		// TODO Auto-generated method stub
		return a.pop();
	}

// 	public static void main(String args[]) {
// 		NewDeque c = new NewDeque();
// 		int j = 15;
// 		System.out.println("Input   " + j + "   Numbers");
// 		System.out.println("before adding numbers, c is empty: " + c.isEmpty());
// 		System.out.println("Adding numbers to stack from back");
// 		for (int i = 0; i <j; i++) {
// 			c.addLast(i);
// 		}
// 		System.out.println("after adding numbers, c is empty: " + c.isEmpty());
// 		//System.out.println("this is front" + " 0 1 2 3 4 5 6 7 8 9 " + "this is back");
// 		System.out.println("first = " + c.first());
// 		System.out.println("last = " + c.last());
// 		c.removeLast();
// 		System.out.println("Removing Last");
// 		System.out.println("last = " + c.last());
// 		c.removeFirst();
// 		System.out.println("Removing First");
// 		System.out.println("first = " + c.first());
// 		System.out.println("Adding First and last: zzzzz and ccccc");
// 		c.addFirst("zzzzz");
// 		c.addLast("ccccc");
// 		System.out.println("last = " + c.last());
// 		System.out.println("first = " + c.first());
// 		System.out.println("Size = " + c.size());

// 	}

}
