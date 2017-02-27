import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class FirstUniquecharInaString {
	public static int firstUniqChar1(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
	public static int firstUniqChar(String s) {

		HashMap<Character, Integer> ht = new HashMap<Character, Integer>();
		int n = s.length();

		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (ht.containsKey(s.charAt(i)) == false) {
				ht.put(s.charAt(i), 1);
			} else {
				int x = Integer.parseInt(ht.get(s.charAt(i)).toString());
				ht.put(s.charAt(i), ++x);
			}

		}
		int i = 0;
		for (i = 0; i < n; i++) {

			int x = Integer.parseInt(ht.get(s.charAt(i)).toString());
			if (x < 2) {
				temp = i;
				return temp;
			}
		}
		temp = -1;
		return temp;
	}

	public static void main(String[] args) {

		Scanner ss = new Scanner(System.in);
		String s = ss.next();
		System.out.println(firstUniqChar(s));
	}
}
