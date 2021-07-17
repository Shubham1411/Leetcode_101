/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public static void reverseArray(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {

        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

        System.out.println("Array elements after rotation:");
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i]+ " ");
    }

    public static void main(String[] args) {

        int nums[] = {1,2,3,4}, k = 6;
        rotate(nums, k);
    }
}
