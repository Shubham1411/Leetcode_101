import java.util.LinkedList;
import java.util.Queue;

/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix {

    public static int[][] updateMatrix(int[][] mat) {

        int rowLength = mat.length;
        int colLength = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (mat[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    mat[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                if (row + 1 >= 0 && row + 1 < rowLength && col >= 0 && col < colLength) {
                    if (mat[row + 1][col] > mat[row][col] + 1) {
                        mat[row + 1][col] = mat[row][col] + 1;
                        queue.offer(new int[]{row + 1, col});
                    }
                }

                if (row - 1 >= 0 && row - 1 < rowLength && col >= 0 && col < colLength) {
                    if (mat[row - 1][col] > mat[row][col] + 1) {
                        mat[row - 1][col] = mat[row][col] + 1;
                        queue.offer(new int[]{row - 1, col});
                    }
                }

                if (row >= 0 && row < rowLength && col + 1 >= 0 && col + 1 < colLength) {
                    if (mat[row][col + 1] > mat[row][col] + 1) {
                        mat[row][col + 1] = mat[row][col] + 1;
                        queue.offer(new int[]{row, col + 1});
                    }
                }

                if (row >= 0 && row < rowLength && col - 1 >= 0 && col - 1 < colLength) {
                    if (mat[row][col - 1] > mat[row][col] + 1) {
                        mat[row][col - 1] = mat[row][col] + 1;
                        queue.offer(new int[]{row, col - 1});
                    }
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {

        int mat[][] = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        mat = updateMatrix(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
