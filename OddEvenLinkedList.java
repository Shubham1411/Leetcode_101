/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
even indices, and return the reordered list.
 */
public class OddEvenLinkedList {
    /*
     * Definition for singly-linked list.
     */
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

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode oddPtr = head, evenPtr = head.next, evenHead = head.next;


        while (oddPtr.next != null && evenPtr.next != null) {

            if (evenPtr != null && evenPtr.next != null) {
                oddPtr.next = evenPtr.next;
                oddPtr = evenPtr.next;
            }

            if (oddPtr != null && oddPtr.next != null) {
                evenPtr.next = oddPtr.next;
                evenPtr = oddPtr.next;
            }
        }

        evenPtr.next = null;
        oddPtr.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        
    }
}
