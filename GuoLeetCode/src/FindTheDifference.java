import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

//寻找两个字符串中的一个不同字符
//两点，1.与一列中有一个不重复的数思想相同,^亦或,同则0不同则1。2.用hashmap
public class FindTheDifference {
	public char findTheDifference1(String s, String t) {
		int n = t.length();
		char temp = t.charAt(n - 1);
		for (int i = 0; i < n - 1; i++) {
			temp ^= s.charAt(i);
			temp ^= s.charAt(i);
		}
		return temp;
	}

	public static char findTheDifference2(String s,String t) {
		int n = t.length();
		Character single = null;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(t.charAt(n-1), 1);
		for (int i = 0; i < n-1; i++) {
			if (map.get(s.charAt(i)) == null) {
				map.put(s.charAt(i), 1);
			}else {
				Integer temp = map.get(s.charAt(i)) + 1;
				if (temp == 2) {
					map.remove(s.charAt(i));
				}
			}
			if (map.get(t.charAt(i)) == null) {
				map.put(t.charAt(i), 1);
			}else {
				Integer temp = map.get(t.charAt(i)) + 1;
				if (temp == 2) {
					map.remove(t.charAt(i));
				}
			}
		}
		
		Iterator<Entry<Character, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			single = (Character) entry.getKey();
		}
		return single;
	}

	public static void main(String[] args) {

	}
}
