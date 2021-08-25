import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a
result, and there will not be any division by zero operation.
 */
public class EvaluateReversePolishNotation {

    //Approach 1: Time: 35 percentile
    public static int evalRPN1(String[] tokens) {

        Stack<String> operands = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String curr = tokens[i];

            if (curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {

                int op1 = Integer.parseInt(operands.pop());
                int op2 = Integer.parseInt(operands.pop());
                Integer res = 0;

                switch (curr) {
                    case "+":
                        res = op1 + op2;
                        break;

                    case "-":
                        res = op1 - op2;
                        break;

                    case "*":
                        res = op1 * op2;
                        break;

                    case "/":
                        res = op1 / op2;
                        break;
                }

                operands.push(res.toString());

            } else {
                operands.push(curr);
            }
        }
        return Integer.parseInt(operands.pop());
    }

    //Approach 2: Time: 92 percentile
    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();

            int result = 0;

            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        String tokens[] = {"2", "1", "+", "3", "*"};

        System.out.println("Value of the Expression : " + evalRPN2(tokens));

    }
}
