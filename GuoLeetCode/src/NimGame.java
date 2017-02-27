import java.util.Scanner;


public class NimGame {
	public static boolean canWinNim(int n) {
		if(n%4==0){
			return false;
		}else {
			return true;
		}
	}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	System.out.println(canWinNim(n));
}
}
