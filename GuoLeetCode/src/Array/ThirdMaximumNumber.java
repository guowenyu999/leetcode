package Array;

import java.util.HashSet;
/*Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.*/
public class ThirdMaximumNumber {

	public static void swap(int a[], int index, int largest) {
		int temp = a[index];
		a[index] = a[largest];
		a[largest] = temp;
	}

	public static void maxHeap(int a[], int heapsize, int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int largest = index;
		if (left < heapsize && a[left] > a[largest]) {
			largest = left;
		}
		if (right < heapsize && a[right] > a[largest]) {
			largest = right;
		}
		if (index != largest) {
			swap(a, index, largest);
			maxHeap(a, heapsize, largest);
		}
	}

	public static void buildMaxHeap(int a[]) {
		if (a == null && a.length <= 1) {
			return;
		}
		int half = (a.length - 1) / 2;

		for (int i = half; i >= 0; i--) {
			maxHeap(a, a.length, i);
		}
	}

	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			swap(array, 0, i);

			maxHeap(array, i, 0);
		}
	}

	public static int thirdMax(int[] nums) {

		HashSet<Integer> hashSet = new HashSet<Integer>();
		buildMaxHeap(nums);
		int i = nums.length - 1;
		int temp = nums[0];
		for (; i >= 1; i--) {
			swap(nums, 0, i);
			hashSet.add(nums[i]);
			if (hashSet.size() == 3) {
				return nums[i];
			}
			maxHeap(nums, i, 0);

		}
		hashSet.add(nums[0]);
		if (hashSet.size() == 3) {
			return nums[i];
		}
		return temp;

	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3,4,5,6};
		 heapSort(a);
		 for (int i = 0; i < a.length; i++) {
		 System.out.println(a[i]);
		 }

//		System.out.println(thirdMax(a));

	}
}
