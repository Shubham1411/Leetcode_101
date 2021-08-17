/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.
 */

import java.util.*;

//Approach: Sort the Array. Then Start iterating the array and fix the nums[i]. Then apply 2 sum approach. We know the
//array is sorted, and so we can use two pointer approach to find the -nums[i] to sum up to 0
//Time: O(n^2) 78 percentile
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        //Sort the Array
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            //Check for duplicates
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1, sum = -nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        //add triplet
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        result.add(triplet);
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int nums[] = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = threeSum(nums);
        System.out.print(res);


    }
}
