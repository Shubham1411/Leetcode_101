/*
Given an array nums and a target value k, find the maximum length of a sub-array that sums to k. If there isn't one,
return 0 instead.
 */
import java.util.HashMap;
import java.util.Map;

public class MaximumSubArrayLength {

    public int maxSubArrayLen(int[] nums, int k) {

        Map<Integer, Integer> m = new HashMap<>();

        int res = 0, sum = 0;
        m.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            //Calculate the prefix sum
            sum += nums[i];

            if (m.containsKey(sum - k)) {
                res = Math.max(res, i - m.get(sum - k));
            }

            //Add the prefix sum if map doesn't contains
            if (!m.containsKey(sum)) {
                m.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
