import java.util.Scanner;

/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {
public static int addDigits(int num) {
	int temp=(num-1)/9;
	int digit=num-9*temp;
	return digit;
}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int num = s.nextInt();
	System.out.println(addDigits(num));
}
}
