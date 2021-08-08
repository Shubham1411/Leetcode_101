/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndofList {

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

    //Approach 1: Calculate the Length of the list. Then move the pointer to len - n positions. A dummy node is
    //considered to avoid null pointer exception since we are deleting a node.
    //Runtime: 0ms, 100%, O(n), Space: O(1),
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return head;

        int len = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;

        //Calculate the length of the linked list
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        //Move current to length - n positions
        curr = dummy;
        for (int i = 0; i < len - n; i++)
            curr = curr.next;

        curr.next = curr.next.next;

        return dummy.next;
    }

    //Approach 2: Using 2 pointer approach. Keep the n distance between the pointers.
    //Dummy pointer is considered to avoid null pointer exception since we are deleting a node.
    //Runtime: 0ms, 100%, O(n), Space: O(1),
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode ptr1 = dummy, ptr2 = dummy;

        //Advance one pointer to n steps
        for (int i = 0; i <= n; i++) {
            ptr1 = ptr1.next;
        }

        //When the 1st pointer reaches end, 2nd will be n behind the last
        while (ptr1 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr2.next = ptr2.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
