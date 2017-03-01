package Array;

/* Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3. */

public class MaxConsecutiveOnes {
	public static int findMaxConsecutiveOnes(int[] nums) {

		int sum = 0;
		int tempsum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				tempsum += 1;
			} else {
				sum=Math.max(tempsum, sum);
				tempsum = 0;
			}
		}
		sum=Math.max(tempsum, sum);
		return sum;
	}

	public static void main(String[] args) {

		int nums[] = {1,0,1,1,0,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}
