package A2;
//Linwei-Wang

//EECS2011 Assignment2

import java.util.ArrayList;

public class Light {
	public static ArrayList<Integer> a = new ArrayList<>();

	public static void turnOff(int n) {
		if (n == 1) {
			a.set(0, 0);
			System.out.println(a);
		}
		if (n == 2) {
			a.set(1, 0);
			System.out.println(a);
			turnOff(n - 1);
		} else {
			if (n > 2) {
				turnOff(n - 2);
				a.set(n - 1, 0);
				System.out.println(a);
			}
			if (n > 2) {
				turnOn(n - 2);
				// System.out.println(a);
				turnOff(n - 1);
			}
		}
	}

	public static void turnOn(int n) {
		if (n == 1) {
			a.set(0, 1);
			System.out.println(a);
		}
		if (n == 2) {
			a.set(0, 1);
			System.out.println(a);
			a.set(1, 1);
			System.out.println(a);
			// turnOn(n-1);
		} else {
			if (n > 2) {
				turnOn(n - 2);
				a.set(n - 2, 1);
				System.out.println(a);
			}
			if (n > 2) {
				turnOff(n - 2);
				// System.out.println(a);
				a.set(n - 1, 1);
				System.out.println(a);
				turnOn(n - 2);
			}
		}
	}

//	public static void main(String arg[]) {
//		int j = 7;
//		for (int i = 0; i < j; i++) {
//			a.add(1);
//		}
//		System.out.println("NUMBER OF LIGHT: "+ j);
//		System.out.println(a);
//		turnOff(j);
//		System.out.println("//////////////////////////////////////////////////" );
//	}

}
