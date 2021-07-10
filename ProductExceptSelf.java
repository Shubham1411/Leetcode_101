/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of
nums except nums[i].
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {

       /* int prod = 1,i,j;
        int ans [] = new int[nums.length];

        for(i=0; i<nums.length; i++){
            prod = 1;
            for(j=0; j<nums.length; j++){
                if(i==j)
                    continue;

                prod = prod * nums[j];
            }
            ans[i] = prod;
        }
        return ans;*/

        //More optimized method

        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int nums [] = {1,2,3,4};

        int res [] = productExceptSelf(nums);

        System.out.println("Result:");
        for (int i=0; i<res.length; i++)
            System.out.print(res[i]+" ");
    }
}
