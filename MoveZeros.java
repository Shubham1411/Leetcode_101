/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of
the non-zero elements. The operation should be done in-place
 */

public class MoveZeros {
    public static void moveZeroes(int[] nums) {

        /*int res [] = new int[nums.length], j=0, k=nums.length-1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)
                res[j++] = nums[i];

            else
                res[k--] = nums[i];
        }*/

        //More optimized in-place operation
        int i,j;

        for(i=0,j=0 ; j<nums.length; j++){

            if(nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        System.out.println("Array elements after moving zeros");
        for(i=0; i<nums.length; i++)
            System.out.print(nums[i] + " ");

    }

    public static void main(String[] args) {
       int arr [] = {0,1};

       moveZeroes(arr);
    }
}
