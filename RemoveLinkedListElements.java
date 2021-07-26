/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val,
and return the new head.
 */
public class RemoveLinkedListElements {

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

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        ListNode curr = head, prev = head;
        while (curr != null) {
            if (curr.val != val) {
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }

        // Head.val == val, move head to next node
        if (head.val == val) head = head.next;
        return head;
    }
}
