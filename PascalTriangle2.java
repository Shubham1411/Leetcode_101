/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 */

import java.util.*;

public class PascalTriangle2 {
    public static List<Integer> getRow(int rowIndex) {

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

    public static void main(String[] args) {

        int rowIndex = 2;

        System.out.println(getRow(rowIndex));

    }
}
