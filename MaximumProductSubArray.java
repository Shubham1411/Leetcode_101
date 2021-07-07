/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and
return the product.
 */
public class MaximumProductSubArray {
    public static int maxProduct(int[] nums) {
        /*int result = nums[0];
        int n = nums.length;

        for (int i = 0; i < n; i++)
        {
            int mul = nums[i];

            for (int j = i + 1; j < n; j++)
            {
                result = Math.max(result, mul);
                mul *= nums[j];
            }
            result = Math.max(result, mul);
        }
        return result;*/

        //Optimized method using

        int localMin = nums[0], localMax = nums[0], globalMax = nums[0];

        for(int i=1; i< nums.length; i++){
            if(nums[i] < 0){
                int temp = localMax;
                localMax = Math.max(localMin * nums[i], nums[i]);
                localMin = Math.min(temp * nums[i], nums[i]);
            }else{
                localMax = Math.max(localMax * nums[i], nums[i]);
                localMin = Math.min(localMin * nums[i], nums[i]);
            }
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int arr [] = {2,3,-2,4};

        System.out.println("Maximum Product of the Sub-Array: "+ maxProduct(arr));
    }
}
