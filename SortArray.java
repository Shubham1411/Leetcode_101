import java.util.Arrays;

/*
Given an array of integers nums, sort the array in ascending order.

Constraints:
1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
 */
public class SortArray {

    //Approach 1: Using Merge Sort. Time: O(n Log n), space: O(n)
    public static int[] sortArray(int[] nums) {

        if (nums.length <= 1)
            return nums;

        //Find the middle index of the array and recursively divide the array into left and right subArrays
        int middle = nums.length / 2;
        int[] leftArray = sortArray(Arrays.copyOfRange(nums, 0, middle));
        int[] rightArray = sortArray(Arrays.copyOfRange(nums, middle, nums.length));

        //Call the merge sort function on the left and right subArrays
        return mergeSort(leftArray, rightArray);

    }

    public static int[] mergeSort(int[] leftArray, int[] rightArray) {

        int len1 = leftArray.length, len2 = rightArray.length;
        int[] result = new int[len1 + len2];

        int l1 = 0, l2 = 0, l3 = 0;

        while (l1 < len1 && l2 < len2) {

            if (leftArray[l1] < rightArray[l2]) {
                result[l3++] = leftArray[l1++];
            } else {
                result[l3++] = rightArray[l2++];
            }
        }

        while (l1 < len1) {
            result[l3++] = leftArray[l1++];
        }

        while (l2 < len2) {
            result[l3++] = rightArray[l2++];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {5, 2, 3, 1};

        nums = sortArray(nums);

        System.out.println("The sorted Array is : ");
        for (int num : nums)
            System.out.println(num + " ");

    }
}
