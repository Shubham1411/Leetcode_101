/*

A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line
in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is
 the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in.
Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].
 */
import java.util.Arrays;
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int count=0,length=heights.length;
        int expected[] = new int[length];

        for(int i=0;i<length;i++)
            expected[i] = heights[i];

        Arrays.sort(expected);

        for(int i=0;i<length;i++)
            if(expected[i] != heights[i])
                count++;

        return count;
    }

    public static void main(String[] args) {

        int heights[] = {5,1,2,3,4};

        System.out.println("Number of students not in correct order: " + heightChecker(heights));
    }
}
