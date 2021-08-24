import java.util.LinkedList;
import java.util.Queue;

/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with
itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class PerfectSquares {

    public static int numSquares(int n) {
        int sqrRoot = (int) Math.sqrt(n), level = 0;
        boolean[] visited = new boolean[n];
        int[] perfectSquare = new int[sqrRoot];

        for (int i = 1; i <= sqrRoot; ++i)
            perfectSquare[i - 1] = i * i;

        Queue<Integer> queue = new LinkedList();
        queue.offer(n);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int num = queue.poll();

                for (int pSquare : perfectSquare) {
                    int remain = num - pSquare;
                    if (remain == 0) {
                        return level;
                    } else if (remain > 0 && !visited[remain - 1]) {
                        visited[remain - 1] = true;
                        queue.offer(remain);
                    } else if (remain < 0) {
                        break;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println("Least number of Perfect Square numbers that sum to n : " + numSquares(n));
    }
}