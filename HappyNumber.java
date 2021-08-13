/*
Write an algorithm to determine if a number n is happy.
 */
/*
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not
include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */

import java.util.Set;
import java.util.HashSet;

public class HappyNumber {

    //Function to calculate the squared sum of the number
    public static int squaredSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    //Approach: When calculating the squared sum, certain pattern of number will repeat after some time.
    //Using HashSet to keep track of those numbers and if duplicates occurs, number is not happy number
    //Time: 80 percentile
    public static boolean isHappy(int n) {

        int sum = 0;
        Set<Integer> hashset = new HashSet<>();

        while (n != 1) {
            n = squaredSum(n);
            if (!hashset.add(n))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int n = 2;
        System.out.println("Happy Number : " + isHappy(n));

    }
}
