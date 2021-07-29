/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */
public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int temp = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            //If 1 is encountered update the counter
            if (nums[i] == 1) {
                temp++;
                if (temp > count)
                    count = temp;
            }

            //If 0 is encountered make counter 0
            if (nums[i] == 0) {
                temp = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int nums[] = {1, 1, 0, 1, 1, 1};
        System.out.println("Maximum Consecutive Ones : " + findMaxConsecutiveOnes(nums));
    }

}
