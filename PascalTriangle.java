/*
Given an integer numRows, return the first numRows of Pascal's triangle.
 */
import java.util.*;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //Adding the initial row
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i=1; i<numRows; i++){
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = result.get(i-1);

            // Adding 1 at the start.
            currRow.add(1);

            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // Adding 1 at the end.
            currRow.add(1);

            result.add(currRow);
        }

        return result;
    }

    public static void main(String[] args) {

        int numRows = 6;

        List<List<Integer>> result = generate(numRows);

        for(int i=0; i<result.size(); i++){
            List<Integer> row = result.get(i);

            for(int j=0; j<row.size(); j++)
                System.out.print(row.get(j) + " ");

            System.out.println();
        }

    }
}
