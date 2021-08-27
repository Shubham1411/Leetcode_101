import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {

    //Approach 1: Brute Force Technique. Time: O(n^2). 1230 ms
    public static int[] dailyTemperatures1(int[] temperatures) {

        int answer[] = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int step = 1;
            for (int j = i + 1; j < temperatures.length; j++) {

                if (temperatures[j] <= temperatures[i])
                    step++;

                else {
                    answer[i] = step;
                    break;
                }
            }
        }
        return answer;
    }

    //Approach 2: Using Stack and then storing the temp and index. Check if Stack[top] is more than daily temp, or else
    // pop from the stack
    public static int[] dailyTemperatures2(int[] temperatures) {

        Stack<int[]> stack = new Stack<>();

        int len = temperatures.length;
        int answer[] = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty())
                stack.push(new int[]{temperatures[i], i});
            else {
                while (!stack.isEmpty()) {
                    int top[] = stack.peek();
                    if (top[0] > temperatures[i]) {
                        answer[i] = top[1] - i;
                        break;
                    } else stack.pop();
                }
                stack.push(new int[]{temperatures[i], i});
            }
        }
        return answer;
    }

    //Approach 3: Using an array as a stack to store the index of the unvisited nodes. Then pop only if the value in the
    //top of stack is less than the current value
    //Time: O(n) 98 percentile, Space: O(n)
    public static int[] dailyTemperatures3(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                result[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return result;
    }

    public static void main(String[] args) {

        int temperatures[] = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        int answer[] = dailyTemperatures2(temperatures);

        for (int ans : answer)
            System.out.print(ans + " ");

    }
}
