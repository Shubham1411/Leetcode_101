/*
You are given a m x n 2D grid initialized with these three possible values.

-1 -> A wall or an obstacle.
0 -> A gate.
INF -> Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the
distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room should remain
filled with INF
 */

import java.util.*;

public class WallsAndGates {

    //Approach 1: Using DFS
    //Time: 97 percentile, 1294 ms
    public static void shortestDistance(int[][] rooms, int row, int col, int distance) {

        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] < distance) return;

        rooms[row][col] = distance;
        shortestDistance(rooms, row + 1, col, distance + 1);
        shortestDistance(rooms, row, col + 1, distance + 1);
        shortestDistance(rooms, row - 1, col, distance + 1);
        shortestDistance(rooms, row, col - 1, distance + 1);
    }

    public static void wallsAndGates1(int[][] rooms) {

        int rowLength = rooms.length;
        int colLength = rooms[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (rooms[i][j] == 0) {
                    shortestDistance(rooms, i, j, 0);
                }
            }
        }
    }

    //Approach 2: Using BFS. Initially, store the location of the Gate=0 in the queue. Next using BFS, poll the element
    // check the adjacent elements if they are in bound and update the distance from Gate=0, only if it is empty room
    //Time: O(n*m), 93.80 percentile, Space: O(n*m)
    public static void wallsAndGates2(int[][] rooms) {

        int rowLength = rooms.length;
        int colLength = rooms[0].length;

        int empty = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();

        //Store the location of gates=0 in the queue
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                if (row + 1 >= 0 && row + 1 < rowLength && col >= 0 && col < colLength && rooms[row + 1][col] == empty) {
                    rooms[row + 1][col] = rooms[row][col] + 1;
                    queue.offer(new int[]{row + 1, col});
                }

                if (row >= 0 && row < rowLength && col + 1 >= 0 && col + 1 < colLength && rooms[row][col + 1] == empty) {
                    rooms[row][col + 1] = rooms[row][col] + 1;
                    queue.offer(new int[]{row, col + 1});
                }

                if (row - 1 >= 0 && row - 1 < rowLength && col >= 0 && col < colLength && rooms[row - 1][col] == empty) {
                    rooms[row - 1][col] = rooms[row][col] + 1;
                    queue.offer(new int[]{row - 1, col});
                }

                if (row >= 0 && row < rowLength && col - 1 >= 0 && col - 1 < colLength && rooms[row][col - 1] == empty) {
                    rooms[row][col - 1] = rooms[row][col] + 1;
                    queue.offer(new int[]{row, col - 1});
                }

            }
        }
    }

    //Approach 3: Same as Approach 2
    public static void wallsAndGates3(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;

        int m = rooms.length;
        int n = rooms[0].length;

        LinkedList<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(i * n + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int head = queue.poll();
            int x = head / n;
            int y = head % n;

            if (x > 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
                rooms[x - 1][y] = rooms[x][y] + 1;
                queue.add((x - 1) * n + y);
            }

            if (x < m - 1 && rooms[x + 1][y] == Integer.MAX_VALUE) {
                rooms[x + 1][y] = rooms[x][y] + 1;
                queue.add((x + 1) * n + y);
            }

            if (y > 0 && rooms[x][y - 1] == Integer.MAX_VALUE) {
                rooms[x][y - 1] = rooms[x][y] + 1;
                queue.add(x * n + y - 1);
            }

            if (y < n - 1 && rooms[x][y + 1] == Integer.MAX_VALUE) {
                rooms[x][y + 1] = rooms[x][y] + 1;
                queue.add(x * n + y + 1);
            }
        }
    }

    public static void main(String[] args) {

        int[][] rooms = {{2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};

        wallsAndGates2(rooms);

        for (int i = 0; i < rooms.length; i++) {

            for (int j = 0; j < rooms[0].length; j++)
                System.out.print(rooms[i][j] + " ");

            System.out.println();
        }

    }
}
