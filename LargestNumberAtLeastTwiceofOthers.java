/*
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array.
If it is, return the index of the largest element, or return -1 otherwise.
 */
public class LargestNumberAtLeastTwiceofOthers {
    public static int dominantIndex(int[] nums) {
        int first=-1, second=-1, index=-1;

        if(nums.length == 1)
            return 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > first){
                second = first;
                first = nums[i];
                index = i;
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        if(second * 2 <= first){
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {

        int nums[] = {3,6,1,0};

        System.out.println("Index Largest Number At Least Twice of Others : " + dominantIndex(nums));

    }
}
