import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//第一次循环时，如果nums[i]对应序号ii，则给num[ii]赋值为负值，第二次循环时直接检查
public class DisappearedArray {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> find = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]);
				if (nums[val - 1] > 0) {
					nums[val - 1] = -nums[val - 1];
			}

		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				find.add(i + 1);
			}
		}
		return find;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = s.nextInt();
		}
		System.out.println(findDisappearedNumbers(nums));
	}
}
