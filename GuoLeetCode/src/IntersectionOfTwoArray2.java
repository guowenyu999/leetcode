import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IntersectionOfTwoArray2 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (hs.containsKey(nums1[i])) {
				hs.put(nums1[i], hs.get(nums1[i]) + 1);
			} else {
				hs.put(nums1[i], 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if (hs.containsKey(nums2[i])) {
				if (hs.get(nums2[i]) == 1) {
					hs.remove(nums2[i]);
				} else {
					hs.put(nums2[i], hs.get(nums2[i]) - 1);
				}
				list.add(nums2[i]);
			}
		}
		int n = list.size();
		int[] arr = new int[n];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		// Integer[] arr = (Integer[])list.toArray(new
		// Integer[size]);//使用了第二种接口，返回值和参数均为结果
		return arr;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int nums1[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums1[i] = s.nextInt();
		}
		int m = s.nextInt();
		int nums2[] = new int[m];
		for (int i = 0; i < m; i++) {
			nums2[i] = s.nextInt();
		}
		int arr[] = intersect(nums1, nums2);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
