/*
Given the head of a singly linked list, return true if it is a palindrome.
 */
public class LinkedListPalindrome {

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

    public boolean isPalindrome(ListNode head) {

        //Using 2 pointers technique
        ListNode fast = head, slow = head;

        //Taking fast ptr to end of the list and slow to the mid of the list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }

        //Reversing the second half of the list
        slow = reverseList(slow);
        fast = head;

        //comparing the nodes of the 1st half and reversed 2nd half
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {

    }
}
