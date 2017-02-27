import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hs=new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i])) {
				return true;
			}else {
				hs.add(nums[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = s.nextInt();
		}
		System.out.println(containsDuplicate(nums));
	}
}
