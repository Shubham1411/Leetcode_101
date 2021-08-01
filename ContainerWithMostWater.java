/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the
x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        //Using two pointer technique
        //Assign left=0 and right=length-1
        int left = 0, right = height.length - 1, max = 0;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
