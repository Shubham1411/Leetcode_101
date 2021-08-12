/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
element is distinct.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    //Approach 1: Sort the array and compare adjacent elements
    //Time: 99 percentile, Space: O(n)
    public static boolean containsDuplicate1(int[] nums) {

        if (nums.length == 1)
            return false;

        //Sort the Array
        Arrays.sort(nums);

        //Checking i with i+1 to check the duplicates
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }

        return false;
    }

    //Approach 2: Using HashSet to check the duplicate elements
    //Time: 55 percentile, Space: O(n)
    public static boolean containsDuplicate2(int[] nums) {

        Set<Integer> hashset = new HashSet<>();

        for (int num : nums) {
            if (hashset.contains(num)) return true;

            hashset.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 4};

        System.out.println("Array Contains Duplicate Elements : " + containsDuplicate2(nums));
    }
}
