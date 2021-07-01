/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order
of the elements may be changed.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {

        int i = 0,j;
        j = nums.length;

        while(i<j){
            if(nums[i] == val){
                nums[i] = nums[j-1];
                j--;
            }else{
                i++;
            }
        }

        System.out.println("Array Elements after removing elements");
        for(j=0; j< nums.length; j++)
            System.out.print(nums[j] + " ");

        System.out.println();

        return i;
    }

    public static void main(String[] args) {

        int [] arr = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(arr, val));
    }
}
