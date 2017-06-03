package Array;

/**
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray1(int[] nums) {
        int start=-1,n=nums.length;
        int end =-2, min = nums[n-1], max = nums[0];
        for(int i=1;i<n;i++) {
            max= Math.max(max,nums[i]);
            min=Math.min(min,nums[n-1-i]);
            if(nums[i]<max){
                end=i;
            }
            if (nums[n-1-i]>min){
                start=n-1-i;
            }
        }
        return end-start+1;
    }
    public static int findUnsortedSubarray(int[] nums) {
        int start=0;
        int end =0;
        outer: for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    start =i;
                    break outer;
                }
            }
        }
        outer: for(int i=nums.length-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(nums[i]<nums[j]){
                    end =i;
                    break outer;
                }
            }
        }
//        System.out.println(end);
//        System.out.println(start);
        if(end>start) {
            return end - start+1;
        }else
            return 0;
    }
    public static void main(String[] args) {
//        int a[] = { 2, 6, 4, 8, 10, 9, 15};
        int a[] = { 2,1};
//        int b = 2;
        System.out.println(findUnsortedSubarray(a));
        System.out.println(findUnsortedSubarray1(a));
    }
}
