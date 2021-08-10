/*
Given a string s, return the number of palindromic substrings in it.
 */
public class PalindromicSubstrings {

    //To check if the given substring is palindrome or not
    public static boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    //Approach 1: Brute Force. Iterate over all the possible substrings and check if they are palindrome or not.
    //Time: O(n^2) 317ms, Space: O(1)
    public static int countSubstrings1(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    //Approach 2: Using two pointer. Consider the ith character as middle and start comparing left-- and right++
    // and increment the count(For Odd). For Even consider 2 pair as middle element.
    //Time: O(n) 3ms, Space: O(1)
    public static int countSubstrings2(String s) {
        int count = 0, len = s.length();

        for (int i = 0; i < len; i++) {

            //For Palindromes of Odd Length
            int left = i, right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                count++;

                left--;
                right++;
            }

            //For Palindromes of Even Length
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                count++;

                left--;
                right++;
            }
        }
        return count;
    }

    //Approach 3: Using two pointer. Consider the ith character as middle and start comparing left-- and right++
    // and increment the count(For Odd). For Even consider 2 pair as middle element.
    //Time: O(n) 2ms, Space: O(1)
    public static int countSubstrings3(String s) {
        if (s == null || s.length() == 0)
            return 0;
        //return solutionII(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    public static int countPalindrome(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {

        String s = "aaa";
        System.out.println("Number of Palindromic Substring : " + countSubstrings3(s));

    }

}
