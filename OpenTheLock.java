import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7',
'8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each
move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will
stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns
required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock {

    //Approach 1: Using BFS. Start with 0000 combination. Add the deadends to the visited list. Use getNextCombiantions
    //to get the rest 8 combinations. Time: 61 percentile.
    //Method to generate next combinations of code
    public static Set<String> getNextCombiantions(String code) {

        Set<String> nextComb = new HashSet<>();
        char codeChar[] = code.toCharArray();

        for (int i = 0; i < 4; i++) {

            char ch = codeChar[i];
            //clockwise
            codeChar[i] = ch == '9' ? '0' : (char) (ch + 1);
            nextComb.add(new String(codeChar));

            //anti-clockwise
            codeChar[i] = ch == '0' ? '9' : (char) (ch - 1);
            nextComb.add(new String(codeChar));

            //codeChar[i] = ch;
        }
        return nextComb;
    }

    public static int openLock1(String[] deadends, String target) {

        int minTurns = 0;

        //Store the different combinations
        Queue<String> queue = new LinkedList<>();

        //Store the visited combinations
        Set<String> visited = new HashSet<>();
        //Add the deadends to visited because we need not consider these combinations
        for (String deadend : deadends)
            visited.add(deadend);

        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String code = queue.poll();

                //If code is in visited ignore
                if (visited.contains(code)) continue;

                //Return minTurns if code equals target
                if (code.equals(target)) return minTurns;

                for (String next : getNextCombiantions(code)) {
                    if (!visited.contains(next)) queue.offer(next);
                }
                visited.add(code);
            }
            minTurns++;
        }
        return -1;
    }


    //Approach 2: Time: 97.21 percentile Space: 92.27 percentile. Using double BFS

    /* s[j] turns one more or from 9 to 0 */
    public String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    /* s[j] turns one less or from 0 to 9 */
    public String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    //Double BFS: begin with both start and target
    public int openLock2(String[] deadends, String target) {
        // opt: discard deads, use visited to cover deadends and visited
        Set<String> visited = new HashSet<>();
        for (String s : deadends) visited.add(s);

        // store strings from start to target
        Set<String> q1 = new HashSet<>();
        // store strings from target to start
        Set<String> q2 = new HashSet<>();

        q1.add("0000");
        q2.add(target);
        int step = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // store all children of cur
            Set<String> temp = new HashSet<>();

            for (String cur : q1) {
                if (visited.contains(cur))
                    continue;
                // meet up, return
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            step++;
            // temp is q1
            // swap q1 and q2, do q2 next
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }


    public static void main(String[] args) {

        String deadends[] = {"0000"}, target = "8888";

        System.out.println("Minimum Total number of Turns Required : " + openLock1(deadends, target));

    }
}
