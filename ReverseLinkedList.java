/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

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

    //Approach 1: Solving it iteratively. Consider a prev ptr, curr=head and next. Using the above three start reversing
    // the list. Time: O(n) 100 percentile, space: O(1)
    public ListNode reverseList1(ListNode head) {

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

    //Approach 2: Recursively solve this problem.
    //Time: O(n) 100 percentile, space: O(n)
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode next = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return head;
    }

    public static void main(String[] args) {

    }
}
