import java.util.Scanner;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		int major = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = s.nextInt();
		}
		System.out.println(majorityElement(nums));
	}
}
