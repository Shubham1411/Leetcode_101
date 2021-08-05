/*
Given a string S, find the length of the longest substring T that contains at most 2 distinct characters.
 */

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class LongestSubstringAtMostTwoDistinctCharacters {
    //Approach: Using 2 pointer and sliding window concept. Time: O(n), Space:O(n)
    //Store the rightmost element in hashmap with index. Whenever window increase from 2, remove the leftmost element
    // to maintain the 2 distinct elements in the window
    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        //If Length of the string = 0
        if (s.length() == 0) return 0;

        //Take 2 pointers left and right
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new HashMap<>();

        int maxLength = 0;

        while (right < s.length()) {
            //Put the rightmost character encountered in the map and increase the right pointer
            rightmostPosition.put(s.charAt(right), right++);

            //If the stored character increase length of 2
            if (rightmostPosition.size() == 3) {
                //Sort and remove the leftmost element
                int lowestIndex = Collections.min(rightmostPosition.values());
                rightmostPosition.remove(s.charAt(lowestIndex));
                //Slide the window
                left = lowestIndex + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String S = "ececebceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(S));
    }
}
