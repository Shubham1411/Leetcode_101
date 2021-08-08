/*
Given an m x n 2D binary grid, grid which represents a map of '1's (land) and '0's (water), return the number of
islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    //Using DFS-BFS to find the adjacent 1s
    public static int findAdjacents(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return 0;

        grid[row][col] = '0';

        //check up
        findAdjacents(grid, row - 1, col);
        //check left
        findAdjacents(grid, row, col - 1);
        //check down
        findAdjacents(grid, row + 1, col);
        //check right
        findAdjacents(grid, row, col + 1);

        return 1;
    }

    public static int numIslands(char[][] grid) {

        int numOfIslands = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {

                if (grid[i][j] == '1')
                    numOfIslands += findAdjacents(grid, i, j);


            }
        }
        return numOfIslands;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println("Number of Islands : " + numIslands(grid));
    }
}
