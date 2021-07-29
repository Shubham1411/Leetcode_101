/*
Given an array nums of integers, return how many of them contain an even number of digits.
 */
public class FindNumbersWithEvenNumberDigits {

    //Find length of the digits
    public static int findLength(int num){

        int count = 0;

        while(num > 0){
            num = num / 10;
            count ++;
        }

        return count;
    }

    public static int findNumbers(int[] nums) {

        int count = 0;

        //loop through the array and invoke the findLength method
        for(int i=0; i<nums.length; i++){
            if(findLength(nums[i]) % 2 == 0)
                count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums [] = {12,345,2,6,7896};

        System.out.println("Numbers of even Number of Digits : "+findNumbers(nums));
    }

}
