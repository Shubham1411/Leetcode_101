/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 */
public class AddTwoNumbersLinkedList {
    // Definition for singly-linked list.
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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = 0, len2 = 0, carry = 0;
        ListNode ptr1 = l1, ptr2 = l2, curr = null;
        ListNode newHead = new ListNode();
        curr = newHead;

        while (ptr1 != null && ptr2 != null) {
            carry += ptr1.val + ptr2.val;
            if (carry < 9) {
                ptr1.val = carry;
                curr.next = ptr1;
                curr = curr.next;
                carry = 0;
            } else {
                ptr1.val = carry % 10;
                curr.next = ptr1;
                curr = curr.next;
                carry /= 10;
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while (ptr1 != null) {
            carry += ptr1.val;
            if (carry < 9) {
                ptr1.val = carry;
                curr.next = ptr1;
                curr = curr.next;
                carry = 0;
            } else {
                ptr1.val = carry % 10;
                curr.next = ptr1;
                curr = curr.next;
                carry /= 10;
            }
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            carry += ptr2.val;
            if (carry < 9) {
                ptr2.val = carry;
                curr.next = ptr2;
                curr = curr.next;
                carry = 0;
            } else {
                ptr2.val = carry % 10;
                curr.next = ptr2;
                curr = curr.next;
                carry /= 10;
            }
            ptr2 = ptr2.next;
        }

        //If there is an extra carry left.
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            curr.next = node;
        }
        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
