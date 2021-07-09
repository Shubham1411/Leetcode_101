/*
Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1
if it is not in nums
 */
public class SearchRotatedArray {
    public static int search(int[] nums, int target) {

        int low=0, high=nums.length-1,mid;

        while(low<high){
            mid = (low+high)/2;
            if(nums[mid] == target)
                return mid;


            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {

        int nums [] = {4,5,6,7,0,1,2}, target = 0;

        System.out.println(search(nums, target));
    }
}
