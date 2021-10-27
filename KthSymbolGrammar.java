/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at
the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

Input: n = 3, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01
row 3: 0110


Constraints:
1 <= n <= 30
1 <= k <= 2n - 1
 */

public class KthSymbolGrammar {

    //Approach 1: Using recursion Time: O(n), Space:O(n)
    public static int kthGrammar(int n, int k) {

        //Base case if n==1, return 0
        if (n == 1) return 0;

        //Find the parent of the node
        int parent = kthGrammar(n - 1, k / 2 + k % 2);

        //Check if k is odd/even
        boolean isKOdd = (k % 2) == 1;

        //If parent is 1, then return 1 if k is odd or else return 0
        if (parent == 1) {
            if (isKOdd)
                return 1;
            else
                return 0;
        } else {//If parent is 0, then return 0 if k is odd or else return 1
            if (isKOdd)
                return 0;
            else
                return 1;
        }

    }

    public static void main(String[] args) {

        int n = 3, k = 1;

        System.out.println(kthGrammar(n, k));

    }

}
