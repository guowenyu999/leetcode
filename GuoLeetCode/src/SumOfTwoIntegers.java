import java.util.Scanner;

public class SumOfTwoIntegers {
	public static int  getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}

	// Iterative
	public static int getSubtract(int a, int b) {
		while (b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		
		return a;
	}

//	// Recursive
//	public int getSum(int a, int b) {
//		return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
//	}
//
//	// Recursive
//	public int getSubtract(int a, int b) {
//		return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
//	}

	// Get negative number减一反码 左侧是一则是负数
	public static int negate(int x) {
		return ~x + 1;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(getSum(a, b));
		System.out.println(getSubtract(a, b));
		System.out.println(negate(a));
	}
}
