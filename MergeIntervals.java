import java.util.*;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        int [][] intervals = {{1,4},{4,5}};

        int res[][] = merge(intervals);

        for(int i=0; i<res.length; i++)
            System.out.println("["+res[i][0]+","+res[i][1]+"]");

    }
}
