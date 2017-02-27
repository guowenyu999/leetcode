import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FizzBuzz {
	public static List<String> fuzzbuzz(int n) {
		List<String> ret=new ArrayList<String>(n);
		for (int i = 1; i <= n; i++) {
			if (i% 3==0&&i%5==0) {
				ret.add("FizzBuzz");
			}else if (i%3==0) {
				ret.add("Fizz");
			}else if (i%5==0) {
				ret.add("Buzz");
			}else {
				ret.add(String.valueOf(i));
			}
		}
		return ret;
	}
public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 int n = s.nextInt();
	 System.out.println(fuzzbuzz(n));
}
}
