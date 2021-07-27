/*
Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateLinkedList {

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

    //Given a linked list, rotate to to k-position to right.
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        int len = 0;
        //Considered a dummy node to keep track of the head node.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy, pos = dummy;

        //Calculate the length of the list.
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }

        //Moving pos to the position from where the list is to be rotated.
        //if k is more than length, so taking mod of the k%length
        for (int j = len - k % len; j > 0; j--)
            pos = pos.next;

        curr.next = dummy.next;
        dummy.next = pos.next;
        pos.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
