/*
Write a function that reverses a string. The input string is given as an array of characters s.

Constraints:
    1 <= s.length <= 105
    s[i] is a printable ascii character.
 */
public class ReverseString {

    //Approach 1: Solving the problem iteratively using 2 pointers. Time: O(n) 2ms Space: O(1)
    public static void reverseString1(char[] s) {

        int i = 0, j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    //Approach 2: Solving the problem recursively. Time: O(n) 1ms, Space: O(1)
    public static void reverseString2(char[] s) {
        reverseStringHelper(0, s.length - 1, s);
    }

    public static void reverseStringHelper(int start, int end, char[] s) {
        if (start > end) {
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverseStringHelper(start + 1, end - 1, s);
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString2(s);
        System.out.println(s);
    }
}
