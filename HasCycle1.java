/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */

import java.util.HashSet;
public class HasCycle1 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Using two pointer approach 1: Slow Pointer and Fast Pointer
    public boolean hasCycle1(ListNode head) {

        if (head == null) return false;

        ListNode fastPtr = head.next, slowPtr = head;

        while (slowPtr != fastPtr) {

            if (fastPtr == null || fastPtr.next == null)
                return false;

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return true;
    }

    //Using HashSet approach 2 //Slower than Approach 1
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;

        ListNode curr = head;
        HashSet<ListNode> list = new HashSet<ListNode>();

        while (curr.next != null) {
            if (list.contains(curr)) return true;

            list.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
