import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class LongestPalindrome {
	public static int longestPalindrome1(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
}
	public static int longestPalindrome(String s) {

		int n = s.length();
		HashMap<Character, Integer> hsHashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++) {
			if (hsHashMap.containsKey(s.charAt(i)) == false) {
				hsHashMap.put(s.charAt(i), 1);
			} else {
				Integer tempInteger = hsHashMap.get(s.charAt(i));
				hsHashMap.put(s.charAt(i), tempInteger + 1);
			}
		}

		int x = 0;
		int count=0;
		Iterator<Entry<Character, Integer>> iter = hsHashMap.entrySet().iterator();
		boolean te=false;
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			int value = (Integer) entry.getValue();
			if (value%2!=0) {
				count+=value-1;
				te=true;
				
			}else {
				count+=value;
			}
		}
		if (te==true) {
			count+=1;
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner ss = new Scanner(System.in);
		String s = ss.next();
		System.out.println(longestPalindrome(s));
	}
}
