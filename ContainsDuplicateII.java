/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such
that nums[i] == nums[j] and abs(i - j) <= k.
 */

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class ContainsDuplicateII {

    //Approach 1: Using HashMap to store the nums[i] along with index. Calculate the distance if it occurs again in the
    //array. Check if distance <= K, then return true or else update the index
    //Time: O(n)
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int distance;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                distance = Math.abs(i - map.get(nums[i]));
                if (distance <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    //Approach 2: Using HastSet and sliding window
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 1}, k = 3;
        System.out.println("Contains Nearby Duplicate : " + containsNearbyDuplicate2(nums, k));
    }
}
