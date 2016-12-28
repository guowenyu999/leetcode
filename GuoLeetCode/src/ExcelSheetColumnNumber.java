import java.util.Scanner;

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {

		int n = s.length();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			char x = s.charAt(i);
			int temp = (x - 'A');
			sum += Math.pow(26, n - 1 - i) * temp;
			if (i != 0) {
				sum += Math.pow(26, i);
			}

		}
		sum+=1;
		return sum;
	}
	//其实整个算法可以想成是26进制的加减乘除
	public static int titleToNumber1(String s) {

		int result = 0;
		for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++);
		return result;
	}
	public static void main(String[] args) {

		Scanner ssScanner = new Scanner(System.in);
		String s = ssScanner.next();
		System.out.println(titleToNumber(s));
	}
}
