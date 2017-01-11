import java.util.Scanner;


public class ValidAnagram {
	public static boolean isAnagram(String s, String t){
		int al[]=new int[26];
		for (int i = 0; i < s.length(); i++) {
			al[s.charAt(i)-'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			al[t.charAt(i)-'a']--;
		}
		for (int i:al) {
			if (i!=0) {
				return false;				
			}
		}
		return true;
	}
public static void main(String[] args) {
	Scanner ss = new Scanner(System.in);
	String s=ss.next();
	String t=ss.next();
	System.out.println(isAnagram(s, t));
}
}
