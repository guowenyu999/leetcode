import java.util.Scanner;

public class RomanToInteger {
	public static int romanToInt(String s) {
		int sum[]=new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			char x=s.charAt(i);
			switch (x) {
			case 'I':
				sum[i]=1;
				break;
			case 'V':
				sum[i]=5;
				break;
			case 'X':
				sum[i]=10;
				break;
			case 'L':
				sum[i]=50;
				break;
			case 'C':
				sum[i]=100;
				break;
			case 'D':
				sum[i]=500;
				break;
			case 'M':
				sum[i]=1000;
				break;
			}
		}
		int value=0;
		for (int i = 0; i < sum.length-1; i++) {
			if (sum[i]<sum[i+1]) {
				value=value-sum[i];
			}else {
				value=value+sum[i];
			}
		}
		value+=sum[sum.length-1];
		return value;
	}

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 String n = s.next();
		 System.out.println(romanToInt(n));
	}
}
