//If the array is sorted then we use two pointer technique to return the elements which adds up to target
/*
Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they
add up to a specific target number.
 */

class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {

        int high = numbers.length - 1, low = 0, temp;
        int result[] = {0,0};

        while (low < high) {
            temp = numbers[low] + numbers[high];
            if (temp == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            } else {
                if (temp > target)
                    high--;
                else
                    low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int res[] = twoSum(nums, target);
        System.out.print("Index are : " + res[0] + " " + res[1]);
    }
}