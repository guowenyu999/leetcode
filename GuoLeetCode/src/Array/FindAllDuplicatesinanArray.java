package Array;

import java.util.ArrayList;
import java.util.List;

/*Given an array of integers, 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]*/
public class FindAllDuplicatesinanArray {
	public static List<Integer> findDuplicates(int[] nums) {

		List<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int temp=nums[Math.abs(nums[i])-1];
			if (temp<0) {
				list.add(Math.abs(nums[i]));
			}else{
				nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
			}
			
		}
		return list;
	}

	public static void main(String[] args) {
int nums[]={10,2,5,10,9,1,1,4,3,7};
List<Integer> xlList=findDuplicates(nums);
for (int i = 0; i < xlList.size(); i++) {
	System.out.println(xlList.get(i));
}
	}
}
