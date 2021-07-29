/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
element is distinct.
 */

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

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
}
