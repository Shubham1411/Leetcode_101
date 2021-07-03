/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
and return its sum.
 */
public class MaximumSumSubArray {
    public static int maxSubArray(int[] nums) {

        int local_max=0, global_max=Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            local_max = Math.max(nums[i], nums[i]+local_max);
            if(local_max > global_max)
                global_max = local_max;

        }

        return global_max;

    }

    public static void main(String[] args) {

        int arr [] = {5,4,-1,7,8};

        System.out.println("Maximum Sum of the Sub-Array: "+ maxSubArray(arr));
    }
}
