/*
Given a multilevel doubly Linked List. You need to flatten it and return the head.
 */
public class FlattenMultilevelDoublyList {
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    public Node flatten(Node head) {

        if (head == null) return null;

        Node curr = head;
        while (curr != null) {

            //If node has no child, proceed to the next node
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }

            //If a node has child, find the tail of the child and link it to curr.next
            Node temp = curr.child;

            // Find the tail of the child
            while (temp.next != null)
                temp = temp.next;

            // Connect tail with p.next, if it is not null
            temp.next = curr.next;

            if (curr.next != null) curr.next.prev = temp;

            // Connect curr with curr.child, and remove curr.child
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
