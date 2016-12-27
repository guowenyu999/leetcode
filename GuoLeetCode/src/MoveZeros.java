import java.util.Scanner;

/*Given an array nums, write a function to move all 0's
 to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12],
 after calling your function, nums should be [1, 3, 12, 0, 0].*/
public class MoveZeros {
	public static void moveZeroes(int[] nums) {
		int temp1 = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nums[temp1] = nums[i];

				temp1++;
			}
		}
		while (temp1 < n) {
			nums[temp1] = 0;
			temp1++;
		}

	}

	public static void moveZeroes1(int[] nums) {
		int temp1 = 0;
		int temp0 = 0;
		int n = nums.length;
		int newnums[]=nums.clone();
		for (int i = 0; i < n; i++) {
			if (newnums[i] != 0) {
				nums[temp1] = newnums[i];
				temp1++;
			}else {
				nums[n-1-temp0] =0;
				temp0++;
			}
		}
		

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = s.nextInt();
		}
		moveZeroes1(nums);
		for (int j = 0; j < nums.length; j++) {
			System.out.println(nums[j]);
		}
	}
}
