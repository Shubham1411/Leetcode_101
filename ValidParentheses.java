/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */

import java.util.Stack;

//Approach: Using Stack. Time: O(n), 98 percentile, Space: O(n)
public class ValidParentheses {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char popped;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            //Push if left ones are there
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;

                //Pop if right ones are there and then check for corresponding left ones
                case ')':
                    if (!stack.isEmpty()) {
                        popped = (Character) stack.pop();
                        if (popped != '(') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;

                case '}':
                    if (!stack.isEmpty()) {
                        popped = (Character) stack.pop();
                        if (popped != '{') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;

                case ']':
                    if (!stack.isEmpty()) {
                        popped = (Character) stack.pop();
                        if (popped != '[') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String s = "()[{]}";

        System.out.println("String has valid Parentheses : " + isValid(s));

    }
}
