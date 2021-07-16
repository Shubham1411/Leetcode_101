/*
Given an input string s, reverse the order of the words.
 */
public class ReverseWords {
    public static String reverseWords(String s) {

        String[] words = s.trim().split(" +");
        String result = "";

        for (int i = words.length-1; i>=0; i--) {
            if(i == 0){
                result += words[i];
            }else {
                result = result + words[i] + " ";
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {

        String s = "  hello     world  ";

        System.out.println(reverseWords(s));

    }
}
