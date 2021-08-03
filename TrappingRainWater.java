/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
it can trap after raining.
 */
public class TrappingRainWater {

    //Approach 1: Brute-Force Technique, traverse the array from start to end and find out the maximum on left
    //and maximum on right of every index. Water stored at i will be min(a,b) – array[i], add this value to the
    // total amount of water stored. Time: O(n^2), 71 ms, Space: O(1)
    public int trap1(int[] height) {

        int max_water = 0;

        for (int i = 1; i < height.length - 1; i++) {
            // Find maximum element on its left
            int left = height[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            // Find maximum element on its right
            int right = height[i];
            for (int j = i + 1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }

            // Update maximum water value
            max_water += Math.min(left, right) - height[i];
        }
        return max_water;
    }

    //Approach 2: Maintain 2 arrays left and right to keep track of the heights and then again loop through the heights
    //and calculate the water trapped by min of left and right height - height of the ith
    //Time: 1ms, O(n), Space: O(n)
    public int trap2(int[] height) {

        int len = height.length, max_water = 0;

        if (len == 0) return 0;

        int left[] = new int[len];
        int right[] = new int[len];

        left[0] = height[0];
        for (int i = 1; i < len; i++)
            left[i] = Math.max(left[i - 1], height[i]);

        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], height[i]);

        for (int i = 0; i < len; i++)
            max_water += Math.min(left[i], right[i]) - height[i];

        return max_water;
    }

    //Approach 3: Using 2 pointers technique to keep track of the max height observed till the element
    //time : O(n), space: O(1). Took lest time and more optimized way
    public static int trap4(int[] height) {
        int max_water = 0, maxLeft = 0, maxRight = 0, i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                maxLeft = Math.max(maxLeft, height[i]);
                max_water += maxLeft - height[i];
                i++;
            } else {
                maxRight = Math.max(maxRight, height[j]);
                max_water += maxRight - height[j];
                j--;
            }
        }
        return max_water;
    }

    public static void main(String[] args) {

    }
}
