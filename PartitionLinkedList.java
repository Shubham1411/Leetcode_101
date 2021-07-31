/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater
than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionLinkedList {
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

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) return head;

        //Initialise two separate list, left and right
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode leftCurr = leftHead, rightCurr = rightHead, curr = head;

        //Loop through the original list. Add <x values to left and >=x values to right
        while (curr != null) {
            if (curr.val < x) {
                leftCurr.next = curr;
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = curr;
                rightCurr = rightCurr.next;
            }
            curr = curr.next;
        }

        //Connect left and right list and return the left one
        rightCurr.next = null;
        leftCurr.next = rightHead.next;
        rightHead = null;

        return leftHead.next;
    }

    public static void main(String[] args) {

    }

}
