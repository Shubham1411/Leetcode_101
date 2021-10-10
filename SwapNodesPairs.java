/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying
the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */

public class SwapNodesPairs {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Approach 1: Recursively swap the nodes. Time: 0ms
    //Time: O(n) Space: O(n)
    public ListNode swapPairs1(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs1(second.next);
        second.next = first;

        return second;

    }


    //Approach 2: Iteratively solve the problem. Time: 0ms
    //Use the dummy node to point to the head node. 
    // Time: O(n) Space: O(n)
    public ListNode swapPairs2(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode prevNode = dummy;
        dummy.next = head;

        while ((head != null) && (head.next != null)) {

            ListNode first = head;
            ListNode second = head.next;

            // Swapping the nodes
            prevNode.next = second;
            first.next = second.next;
            second.next = first;

            prevNode = first;
            head = first.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
