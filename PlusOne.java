/*
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer that the
digits in the array represent
 */
import java.util.*;
public class PlusOne {
    public static int[] plusOne(int[] digits) {

        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [digits.length+1];
        newNumber[0] = 1;

        return newNumber;

    }

    public static void main(String[] args) {

        int digits [] = {9,9};

        int result [] = plusOne(digits);

        System.out.println("Array after manipulation:");
        for(int i=0; i<result.length; i++)
            System.out.print(result[i]+" ");
    }
}
