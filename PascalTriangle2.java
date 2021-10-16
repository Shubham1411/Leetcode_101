/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */

import java.util.*;

public class PascalTriangle2 {

    //Approach 1: Using an iterative approach. Initially add 1 for the 1st element. Outer loop iterates from 1 to
    //rowIndex and the inner loop from 1 to i-1. Compute the result by adding res(j-1) + res(j)
    //Time: O(n^2) Space: O(n)
    public static List<Integer> getRow1(int rowIndex) {

        List<Integer> result = new ArrayList<Integer>();
        //Adding 1 at the start
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int temp = result.get(j - 1) + result.get(j);
                result.set(j, temp);
            }

            //Adding 1 at the end
            result.add(1);
        }

        return result;
    }

    //Approach 2: Using recursion and using the formula, F(i,j) = F(i-1, j-1) + F(i-1, j)
    //Gives Time Limit Exceed error
    private static int getNum(int row, int col) {
        if (row == 0 || col == 0 || row == col) {
            return 1;
        }

        return getNum(row - 1, col - 1) + getNum(row - 1, col);
    }

    public static List<Integer> getRow2(int rowIndex) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i));
        }

        return ans;
    }



    public static void main(String[] args) {

        int rowIndex = 3;

        System.out.println(getRow2(rowIndex));

    }
}
