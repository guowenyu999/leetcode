import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int j = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length && j < nums2.length;) {

			while (i < nums1.length - 1) {
				if (nums1[i] == nums1[i + 1]) {
					i++;
				} else {
					break;
				}

			}

			while (j < nums2.length - 1) {
				if (nums2[j] == nums2[j + 1]) {
					j++;
				} else {
					break;
				}

			}
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			}else if (nums1[i] < nums2[j]){
				i++;
			}else {
				j++;
			}
			
		}
		int size = list.size();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = list.get(i);
		}

		return arr;
	}
	public static int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> set=new HashSet<Integer>();
		Set<Integer> set2=new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				set2.add(nums2[i]);
			}
		}
		int[] fin=new int[set2.size()];
		int x=0;
		for (Integer num : set2) {
			fin[x++]=num;
		}
		return fin;
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
		int arr[] = intersection(nums1, nums2);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
