/*
Write an efficient algorithm that searches for a target value in an m x n integer matrix.

The matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
 */

public class Search2DMatrixII {

    //Approach 1: Using Binary Search Technique. 1st check the value of the target if it is within the range of the
    //current row. If yes, then apply Binary Search technique in the particular row.
    //Time: 0(n^2), Space: 0(1)
    public static boolean searchMatrix1(int[][] matrix, int target) {

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

    //Approach 2: 
    public static boolean searchMatrix2(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;

        int i = rows - 1, j = 0;

        while (i >= 0 && j < cols) {
            if (target == matrix[i][j])
                return true;
            else {
                if (target > matrix[i][j]) {
                    j++;
                } else {
                    i--;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 33;

        System.out.println("The matrix contains the Target value : " + searchMatrix2(matrix, target));

    }
}
