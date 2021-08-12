import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {

    //Approach 1: Sort the array and keep checking the adjacent numbers for duplicates
    //Time: O(n) but the performance was not good. 5 ms, 50 percentile
    public static int singleNumber1(int[] nums) {

        //sort the array
        Arrays.sort(nums);
        int len = nums.length, i = 0;

        while (i < len - 1) {
            if (nums[i] != nums[i + 1])
                return nums[i];

            i += 2;
        }

        if (i < len) return nums[len - 1];

        return -1;

    }

    //Approach 2: Using XOR operator to check for duplicates
    //Time: O(n) 99 percentile space: O(n)
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    //Approach 3: Using HashSet to track the duplicate elements
    public static int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num))
                set.remove(num);
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }

    public static void main(String[] args) {

        int nums[] = {1, 2, 4, 1, 2};
        System.out.println("Single Number is : " + singleNumber3(nums));
    }
}
