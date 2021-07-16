/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
and initial word order.
 */
public class ReverseWords3 {
    public static String reverseWords(String s) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                int j = i;
                while (j + 1 < arr.length && arr[j + 1] != ' ') {
                    j++;
                }
                reverse(arr, i, j);
                i = j;
            }
        }
        return new String(arr);
    }

    private static void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
    }
}
