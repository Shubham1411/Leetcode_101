/*
Given a string s, find the length of the longest substring without repeating characters
 */

import java.util.Set;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    //Approaches: Both approaches uses Sliding window concept and a HashSet to maintain unique characters count
    //Time: O(n) , 6ms, Space:O(n)
    public static int lengthOfLongestSubstring1(String s) {

        if (s.length() == 0) return 0;

        int maxLength = 0;
        int windowStart = 0;

        Set<Character> frequency = new HashSet<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            char ch = s.charAt(windowEnd);

            while (frequency.contains(ch)) {
                frequency.remove(s.charAt(windowStart));
                windowStart++;
            }
            frequency.add(ch);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) return 0;

        int maxLength = 0;
        int windowStart = 0, windowEnd = 0;

        Set<Character> frequency = new HashSet<>();

        while (windowEnd < s.length()) {

            char ch = s.charAt(windowEnd);

            if (frequency.contains(ch)) {
                frequency.remove(s.charAt(windowStart));
                windowStart++;
            } else {
                frequency.add(ch);
                windowEnd++;
                maxLength = Math.max(maxLength, frequency.size());
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println("Longest Substring Without Repeating Characters : " + lengthOfLongestSubstring2(s));
    }
}
