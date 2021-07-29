/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        Character ch;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                //If a left open parentheses is encountered push to stack
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;

                //Now pop and check if same type of right open parentheses is popped or else return false
                case ')':
                    if (stack.isEmpty() == false) {
                        ch = (Character) stack.pop();
                        if (ch != '(') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() == false) {
                        ch = (Character) stack.pop();
                        if (ch != '{') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() == false) {
                        ch = (Character) stack.pop();
                        if (ch != '[') {
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
