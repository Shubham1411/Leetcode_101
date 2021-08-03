/*
Given an sorted rotated array without duplicate elements. Find out the minimum element in the array.
 */
public class FindMinimumInRotatedSortedArray {

    //Approach: Using modified binary search we can solve this in O(log n). Runtime: 1 ms
    public int findMin(int[] nums) {

        //If length is 1 return the element
        if (nums.length == 1) {
            return nums[0];
        }

        int lo = 0, hi = nums.length - 1, mid = 0;

        //Check if array is not rotated and only sorted, return the 1st element
        if (nums[lo] < nums[hi])
            return nums[lo];

        //Using modified binary search technique
        while (lo < hi) {

            mid = (lo + hi) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

    }

}
