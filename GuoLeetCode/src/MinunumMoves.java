import java.util.Arrays;
import java.util.Scanner;

public class MinunumMoves {
	public static int minMoves(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		int n = nums.length;
		int min = nums[0];
		for (int i = 1; i < n; i++) {
			sum += nums[i] - min;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = s.nextInt();
		}
		System.out.println(minMoves(nums));
	}
}
