import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Scanner;

public class SingleNumber {
	public static int singleNumber(int[] nums) {
//		int single = -1;
//		boolean f = false;
//		for (int i = 0; i < nums.length - 1; i = i + 2) {
//			if (nums[i] != nums[i + 1]) {
//				single = nums[i];
//				f = true;
//				break;
//			}
//		}
//		if (f == false) {
//			single = nums[nums.length - 1];
//		}
//		return single;
		int single=0;
		HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();  
		for (int i = 0; i<nums.length; i++)
	    {
			if (map.get(nums[i])==null) {
				map.put(nums[i], 1);
			}else {
				Integer temp=map.get(nums[i])+1;
				if (temp==2) {
					map.remove(nums[i]);
				}
			}			
	    }
		Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
		Entry entry = (Entry) iter.next();
		single = (Integer) entry.getKey();
		}
		return single;
	}
	public static int singleNumber1(int[] nums) {
	     int result = 0;
	    for (int i = 0; i<nums.length; i++)
	    {
			result ^=nums[i];
	    }
		return result;
	    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = s.nextInt();
		}
		System.out.println(singleNumber(nums));

	}
}
