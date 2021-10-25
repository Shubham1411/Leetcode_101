/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Constraints:
-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
 */
public class Pow {

    //Approach 1: Iteratively multiplying x with itself n times. Changing n = -n and x = 1/x, if n<0
    //Time Limit Exceed error for higher values of n
    //Time complexity : O(n). We will multiply x for n times Space complexity : O(1)
    public static double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;

        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }

    //Approach 2: Using Fast power technique + recursion
    //Time complexity : O(log n) Space: O(log n)
    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    public static void main(String[] args) {

        System.out.println(myPow2(10.30, 2));

    }
}
