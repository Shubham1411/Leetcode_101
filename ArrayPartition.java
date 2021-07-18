/*
Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such
that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
 */
import java.util.Arrays;
public class ArrayPartition {
    public static int arrayPairSum(int[] nums) {

        int sum = 0, i;
        Arrays.sort(nums);

        for(i=0; i<nums.length; i+=2){
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        int nums[] = {6,2,6,5,1,2};

        System.out.println("Maximized Sum = " + arrayPairSum(nums));
    }
}
