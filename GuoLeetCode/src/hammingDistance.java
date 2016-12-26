import java.util.Scanner;


public class hammingDistance {
public static int hamming(int x,int y) {
	return Integer.bitCount(x^y);//有多少个1
}
public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 int x = s.nextInt();
	 int y = s.nextInt();
	System.out.println(hamming(x, y)); 
}
}
