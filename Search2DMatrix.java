/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */
public class Search2DMatrix {

    //Approach : Using Binary Search Technique. 1st check the value of the target if it is within the range of the
    //current row. If yes, then apply Binary Search technique in the particular row.
    //Time: 0(n^2), Space: 0(1)
    public static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            //Checking if the target is present in the current range of the row
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {

                int low = 0, high = cols - 1, mid = 0;

                while (low <= high) {

                    mid = (low + high) / 2;

                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (target < matrix[i][mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        //int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //int target = 3;

        int[][] matrix = {{1}};
        int target = 1;

        System.out.println("The matrix contains the Target value : " + searchMatrix(matrix, target));

    }
}
