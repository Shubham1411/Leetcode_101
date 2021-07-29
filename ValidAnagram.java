/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        int count [] = new int[26];

        if(s.length() != t.length())
            return false;

        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 97]++;
            count[t.charAt(i) - 97]--;
        }


        for(int i=0; i<26; i++)
            if(count[i] != 0)
                return false;

        return true;

    }

    public static void main(String[] args) {
        String s = "anagram", t = "nlgaram";

        System.out.println(isAnagram(s,t));

    }
}
