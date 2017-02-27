import java.util.Scanner;


public class ReverseString {//将字符串进行倒置
public static String reverseString(String s) {
	StringBuffer sb = new StringBuffer (s);
	return sb.reverse().toString();
        
    }
public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 String str = s.next();
//	 reverseString(str);
	 System.out.println(reverseString(str));
}
}
