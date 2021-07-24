/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */

import java.util.HashSet;

public class HasCycle2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle1(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode curr = head;
        HashSet<ListNode> list = new HashSet<ListNode>();

        while (curr.next != null) {
            if (list.contains(curr)) return curr;

            list.add(curr);
            curr = curr.next;
        }

        return null;

    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                break;
            }
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode node = head;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return node;

    }

    public static void main(String[] args) {

    }
}
