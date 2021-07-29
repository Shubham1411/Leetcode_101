/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
non-decreasing order.
 */
public class SquareSortedArray {
    public static int[] sortedSquares(int[] A) {
        int N = A.length;
        int j = 0;

        //Finding the element from where positive number start
        //Dividing the array into two part negative and positive
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        //Using merge sort technique to solve it
        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr [] = {-4,-1,0,3,10};

        int res [] = sortedSquares(arr);

        System.out.println("Array after squared and sorted: ");
        for(int i=0; i<res.length; i++)
            System.out.print(res[i]+" ");
    }
}
