/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Technique : Word by Word Matching
 */
public class LongestCommonPrefix {

    //Function to find common prefix between 2 strings str1 and str2
    public static String commonPrefix(String str1, String str2){
        String result = "";
        int l1=str1.length(), l2=str2.length();

        for(int i=0,j=0; i<l1 && j<l2; i++,j++){
            if(str1.charAt(i) != str2.charAt(j))
                break;

            result += str1.charAt(i);
        }
        return result;
    }

    //A Function that returns the longest common prefix from the array of strings
    public static String longestCommonPrefix(String[] strs) {

        String prefix= strs[0];

        for (int i = 1; i<strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    public static void main(String[] args) {

        String [] strs = {"dog","racecar","car"};

        System.out.println("Longest Common Prefix : " + longestCommonPrefix(strs));

    }
}
