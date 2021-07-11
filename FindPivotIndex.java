/*
Given an array of integers nums, calculate the pivot index of this array. The pivot index is the index where the sum of
 all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 */
public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {

        int sum=0, leftSum=0;

        for( int num: nums)
            sum += num;

        for(int i=0; i< nums.length; i++){
            if(leftSum == sum-leftSum-nums[i])
                return i;

            leftSum+= nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        int nums [] = {2,1,-1};

        System.out.println("Pivot Index is:" + pivotIndex(nums));
    }
}
