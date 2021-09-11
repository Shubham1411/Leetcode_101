import java.util.Stack;

/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat
numbers, k. For example, there won't be input like 3a or 2[4].

Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */
public class DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int index = 0;

        while (index < s.length()) {
            char curr = s.charAt(index);
            if (Character.isDigit(curr)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (curr == '[') {
                result.push(res);
                res = "";
                index++;
            } else if (curr == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            } else {
                res += curr;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "3[a]2[bc]";
        System.out.println("Decoded String : " + decodeString(s));

    }
}
