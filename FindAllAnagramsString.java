import java.util.*;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
in any order.
 */
public class FindAllAnagramsString {

    //Approach 1: Using HashMap and sliding window. Performance was not good.
    //Time: 6 ms
    public static List<Integer> findAnagrams1(String s, String p) {

        List<Integer> result = new ArrayList<>();

        //Store the frequency of characters in String p
        Map<Character, Integer> charsCountP = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char currChar = p.charAt(i);
            charsCountP.put(currChar, charsCountP.getOrDefault(currChar, 0) + 1);
        }

        //Counter to track the occurrence of characters of s in p
        int counter = p.length();
        int windowStart = 0, windowEnd = 0;
        Map<Character, Integer> charsCountS = new HashMap<>();

        for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            charsCountS.put(currChar, charsCountS.getOrDefault(currChar, 0) + 1);

            if (windowEnd >= counter) {
                char charLeft = s.charAt(windowEnd - counter);
                if (charsCountS.get(charLeft) == 1) charsCountS.remove(charLeft);
                else charsCountS.put(charLeft, charsCountS.get(charLeft) - 1);
            }

            if (charsCountS.equals(charsCountP))
                result.add(windowEnd - counter + 1);
        }
        return result;
    }

    //Approach 2: Using arrays to count the frequency and sliding window concept
    //Time: O(n),  5 ms, Space: O(m+n)
    public static List<Integer> findAnagrams2(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[] arrS = new int[26];
        int[] arrP = new int[26];
        List<Integer> res = new ArrayList<>();

        //Count the frequency of characters in P
        for (char ch : p.toCharArray())
            arrP[ch - 'a']++;

        for (int right = 0; right < n; right++) {
            char chR = s.charAt(right);
            arrS[chR - 'a']++;

            if (right >= m) {
                char chL = s.charAt(right - m);
                arrS[chL - 'a']--;
            }

            if (Arrays.equals(arrS, arrP))
                res.add(right - m + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";

        System.out.println("Indices were Anagram starts : " + findAnagrams2(s, p));
    }
}
