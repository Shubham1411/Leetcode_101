/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other
uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
*/

//Approach: Using Sliding window. Keep track of frequency of the characters encountered
//If the number of characters to be changed increase more than k, shift the windowStart to right
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {

        int N = s.length();
        //To maintain the frequency of the encountered characters
        int[] charsCount = new int[26];

        int windowStart = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < N; windowEnd++) {

            //Increment the count the current character
            charsCount[s.charAt(windowEnd) - 'A']++;
            int currentCharCount = charsCount[s.charAt(windowEnd) - 'A'];
            maxCount = Math.max(maxCount, currentCharCount);

            //If the window size is more than k shift the windowStart to right by 1 position
            while (windowEnd - windowStart + 1 - maxCount > k) {
                charsCount[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 2;

        System.out.println("Length of the Longest substring with repeating character replacement : " +
                characterReplacement(s, k));

    }
}
