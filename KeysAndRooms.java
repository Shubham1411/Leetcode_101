import java.util.*;

/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the
rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it
unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can
visit all the rooms, or false otherwise.

Constraints:
n == rooms.length
2 <= n <= 1000
0 <= rooms[i].length <= 1000
1 <= sum(rooms[i].length) <= 3000
0 <= rooms[i][j] < n
All the values of rooms[i] are unique.
 */
public class KeysAndRooms {

    public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();

            for (int ele : rooms.get(room)) {
                if (!visited.contains(ele)) {
                    visited.add(ele);
                    stack.push(ele);
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i))
                return false;
        }

        return true;
    }

    public static boolean canVisitAllRooms2(List<List<Integer>> rooms) {

        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[rooms.size()];

        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int room = stack.pop();

            for (int ele : rooms.get(room)) {
                if (!visited[ele]) {
                    visited[ele] = true;
                    stack.push(ele);
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();

        List l1 = new ArrayList();
        l1.add(1);

        List l2 = new ArrayList();
        l2.add(2);

        List l3 = new ArrayList();
        l3.add(3);

        List l4 = new ArrayList();

        rooms.add(l1);
        rooms.add(l2);
        rooms.add(l3);
        rooms.add(l4);

        System.out.println("All the rooms can be visited : " + canVisitAllRooms2(rooms));
    }
}
