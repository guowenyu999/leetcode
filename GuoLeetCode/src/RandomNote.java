import java.util.HashMap;
import java.util.Scanner;

/*Given an arbitrary ransom note string and another string containing letters
from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; 
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.*/

public class RandomNote {
	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int n=magazine.length();
		int m=ransomNote.length();
		for (int i = 0; i < n; i++) {
			Character xCharacter=magazine.charAt(i);
			if (map.containsKey(xCharacter)) {
				int count=map.get(xCharacter);
				map.put(xCharacter,count+1);
			}else {
				map.put(xCharacter,1);
			}			
		}
		for (int i = 0; i < m; i++) {
			Character yCharacter=ransomNote.charAt(i);
			if (map.containsKey(yCharacter)) {
				int count=map.get(yCharacter);
				if (count>1) {
					map.put(yCharacter, count-1);
				}
				else {
					map.remove(yCharacter);
				}
			}else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String ransomNote=s.next();
		String magazine=s.next();
		System.out.println(canConstruct(ransomNote, magazine));
	}
}
