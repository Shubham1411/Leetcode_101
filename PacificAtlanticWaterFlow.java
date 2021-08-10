/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches
the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c]
represents the height above sea level of the cell at coordinate (r, c).
The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and
west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell
adjacent to an ocean into the ocean.
Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from
cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
import java.util.*;

public class PacificAtlanticWaterFlow {

    static int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void DFS_BFS(int[][] heights, int row, int col, int prev, boolean[][] ocean) {
        if (row < 0 || row >= ocean.length || col < 0 || col >= ocean[0].length) return;
        if (heights[row][col] < prev || ocean[row][col]) return;

        ocean[row][col] = true;

        for (int[] d : dir) {
            DFS_BFS(heights, row + d[0], col + d[1], heights[row][col], ocean);
        }
    }

    //Start traversing from outside to inside the islands using the DFS-BFS approach.
    //Mark the cells separately as reachable from Pacific or Atlantic and merge the commons at last.
    //Time: O(N*M), Space: O(N+M)
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        int rowLength = heights.length;
        int colLength = heights[0].length;

        if (heights == null || rowLength == 0 || colLength == 0) return result;

        boolean[][] pacific = new boolean[rowLength][colLength];
        boolean[][] atlantic = new boolean[rowLength][colLength];

        //Top and Bottom rows
        for (int i = 0; i < colLength; i++) {
            DFS_BFS(heights, 0, i, Integer.MIN_VALUE, pacific);
            DFS_BFS(heights, rowLength - 1, i, Integer.MIN_VALUE, atlantic);
        }

        //Left and Right rows
        for (int i = 0; i < rowLength; i++) {
            DFS_BFS(heights, i, 0, Integer.MIN_VALUE, pacific);
            DFS_BFS(heights, i, colLength - 1, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] heights = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};

        System.out.println("Result Co-ordinates : " + pacificAtlantic(heights));
    }
}
