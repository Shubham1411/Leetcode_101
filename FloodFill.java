/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the
pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same
color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
 */
public class FloodFill {

    public static void DFS(int[][] image, int row, int col, int newCol, int oldCol) {

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] == newCol)
            return;

        if (image[row][col] == oldCol) {
            image[row][col] = newCol;
            DFS(image, row + 1, col, newCol, oldCol);
            DFS(image, row - 1, col, newCol, oldCol);
            DFS(image, row, col + 1, newCol, oldCol);
            DFS(image, row, col - 1, newCol, oldCol);
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldCol = image[sr][sc];

        DFS(image, sr, sc, newColor, oldCol);

        return image;
    }

    public static void main(String[] args) {

        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, sr = 1, sc = 1, newColor = 2;

        int res[][] = floodFill(image, sr, sc, newColor);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
