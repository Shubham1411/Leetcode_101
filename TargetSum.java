/*
You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
 */
public class TargetSum {

    static int count = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return count;
    }

    public static void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public static void main(String[] args) {

        int nums[] = {1, 1, 1, 1, 1}, target = 3;

        System.out.println("Number of Different Expressions : " + findTargetSumWays(nums, target));
    }
}
