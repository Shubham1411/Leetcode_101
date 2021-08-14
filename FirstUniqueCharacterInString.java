/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

import java.util.Map;
import java.util.HashMap;

public class FirstUniqueCharacterInString {

    //Approach 1: Using HashMap to count the frequency of each character in the string. Then again iterate the string
    //Return the 1st encountered character with frequency 1
    //Time: O(N), space:O(1)
    public static int firstUniqChar1(String s) {

        Map<Character, Integer> charCount = new HashMap<>();

        //Store the frequency of each char
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            charCount.put(currChar, charCount.getOrDefault(currChar, 0) + 1);
        }

        //Return the index of the 1st char with frequency=1
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (charCount.get(currChar) == 1)
                return i;
        }

        return -1;
    }

    //Approach 2: Using Array of 26 size to count the frequency of each character in the string. Then again iterate
    // the string Return the 1st encountered character with frequency 1
    //Time: O(N), space:O(1)
    public static int firstUniqChar2(String s) {

        int[] charCount = new int[26];

        //Store the frequency of each char in the array
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        //Return the index of the 1st char with frequency=1
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        String s = "leetcode";

        System.out.println("Index of first non-repeating Character : " + firstUniqChar2(s));

    }
}
