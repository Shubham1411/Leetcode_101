/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every cha
racter in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 */

import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {

    //Approach: Sliding Window and usage of HashMap to keep track of frequency of the encountered characters
    //Time: O(n), Space: O(n)
    public static String minWindow(String s, String t) {

        String substring = "";

        //Store the frequency of characters in String t
        Map<Character, Integer> charsCountT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            charsCountT.put(currChar, charsCountT.getOrDefault(currChar, 0) + 1);
        }

        int windowStart = 0, windowEnd = 0, counter = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> charsCountS = new HashMap<>();

        int have = t.length();

        for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            //Store the frequency of characters in String s
            charsCountS.put(currChar, charsCountS.getOrDefault(currChar, 0) + 1);

            //Incrementing the counter till we have reached the number of characters required
            if (charsCountS.get(currChar) <= charsCountT.getOrDefault(currChar, 0)) counter++;

            //When we have reached the number of characters required in the s string
            while (counter == have) {

                char chL = s.charAt(windowStart);

                if (windowEnd - windowStart + 1 < minLen) {
                    minLen = windowEnd - windowStart + 1;
                    if (windowStart == 0) substring = s.substring(windowStart, windowEnd + 1);
                    else substring = s.substring(windowStart, windowStart + minLen);
                }

                //Decrement the count of character in the map of s
                if (charsCountT.containsKey(chL) && charsCountS.get(chL) <= charsCountT.get(chL))
                    counter--;
                charsCountS.put(chL, charsCountS.get(chL) - 1);
                windowStart++;

            }
        }

        return substring;
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("Minimum Window Substring is : " + minWindow(s, t));
    }
}
