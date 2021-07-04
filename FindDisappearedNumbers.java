import java.util.ArrayList;
import java.util.List;
/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the
range [1, n] that do not appear in nums.
 */
public class FindDisappearedNumbers {
    public static void findDisappearedNumbers(int[] nums) {

        List<Integer> missing = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]);
            //System.out.println(index);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                missing.add(i+1);
                System.out.println(i+1);
            }
        }

    }

    public static void main(String[] args) {
        int arr [] = {4,3,2,7,8,2,3,1};

        findDisappearedNumbers(arr);
    }
}
