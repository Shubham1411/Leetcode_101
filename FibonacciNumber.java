import java.util.HashMap;
import java.util.Map;

/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is
the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.

Given n, calculate F(n).
 */
public class FibonacciNumber {

    //Approach 1: Simple Recursion
    //Time: 8ms
    public static int fib1(int n) {

        if (n < 2)
            return n;

        return fib1(n - 1) + fib1(n - 2);

    }

    //Approach 2: Recursion + Memoization (Top-Down Approach)
    //Time: 0ms
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib2(int n) {

        int val = 0;
        if (memo.containsKey(n))
            return memo.get(n);

        if (n < 2)
            return n;

        val = fib2(n - 1) + fib2(n - 2);
        memo.put(n, val);
        return memo.get(n);

    }

    //Approach 3: Iterative + Tabulation (Bottom-Up Approach)
    //Time: 0ms
    public static int fib3(int n) {

        if (n <= 1)
            return n;

        int arr[] = new int[n + 1];
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }


    public static void main(String[] args) {
        System.out.println(fib3(4));
    }
}
