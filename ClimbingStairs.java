import java.util.HashMap;
import java.util.Map;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    //Approach 1: Simple recursion
    //Time Limit Exceed error Time: O(2^n)
    public static int climbStairs1(int n) {

        return helperClimbStairs(n, 0);

    }

    public static int helperClimbStairs(int n, int k) {

        if (k > n)
            return 0;

        if (k == n)
            return 1;

        return helperClimbStairs(n, k + 1) + helperClimbStairs(n, k + 2);

    }

    //Approach 2: Recursion + Memoization
    //Time: O(n) Space: O(n)
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int climbStairs2(int n) {

        return helperClimbStairs2(n, 0);

    }

    public static int helperClimbStairs2(int n, int k) {

        if (memo.containsKey(k))
            return memo.get(k);

        if (k > n)
            return 0;

        if (k == n)
            return 1;

        int val = helperClimbStairs2(n, k + 1) + helperClimbStairs2(n, k + 2);
        memo.put(k, val);
        return memo.get(k);

    }

    //Approach 3: Recursion + Memoization(Using Array)
    //Time: O(n) Space: O(n)
    public int climbStairs3(int n) {

        int memo[] = new int[n + 1];
        return helperClimbStairs3(n, 0, memo);

    }

    public int helperClimbStairs3(int n, int k, int memo[]) {

        if (k > n)
            return 0;

        if (k == n)
            return 1;

        if (memo[k] > 0)
            return memo[k];

        memo[k] = helperClimbStairs3(n, k + 1, memo) + helperClimbStairs3(n, k + 2, memo);
        return memo[k];

    }

    //Approach 4: Iterative + Using DP + Bottom Up Approach
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(climbStairs2(5));

    }
}
