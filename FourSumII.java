import java.util.HashMap;
import java.util.Map;

/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l)
such that:
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

Constraints:
n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class FourSumII {

    //Approach 1: Brute Force approach. Time Limit exceed error
    public static int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int count = 0;

        for (int num1 : nums1)
            for (int num2 : nums2)
                for (int num3 : nums3)
                    for (int num4 : nums4)
                        if (num1 + num2 + num3 + num4 == 0)
                            count++;

        return count;
    }

    //Approach 2: Using HashMap. Store frequency of the sum of 2 arrays in a HashMap. Next iterate the next 2 arrays and
    //check for the counter-sum of their values in the hashmap.
    //Time: O(n^2) 95 percentile
    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num3 : nums3)
            for (int num4 : nums4)
                hashMap.put(num3 + num4, hashMap.getOrDefault(num3 + num4, 0) + 1);

        for (int num1 : nums1)
            for (int num2 : nums2)
                count += hashMap.getOrDefault(-(num1 + num2), 0);

        return count;
    }

    public static void main(String[] args) {

        int nums1[] = {1, 2}, nums2[] = {-2, -1}, nums3[] = {-1, 2}, nums4[] = {0, 2};

        System.out.println("Number of tuples satisfy 4 sum condition : " + fourSumCount1(nums1, nums2, nums3, nums4));
    }
}
