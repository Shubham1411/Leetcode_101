/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the
two linked lists have no intersection at all, return null.
 */

import java.util.HashSet;

public class GetIntersectionNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Approach 1: Using HashSet, this method is inefficient.
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;

        HashSet<ListNode> list = new HashSet<ListNode>();

        while (ptrA != null) {
            list.add(ptrA);
            ptrA = ptrA.next;
        }

        while (ptrB != null) {
            if (list.contains(ptrB)) return ptrB;

            list.add(ptrB);
            ptrB = ptrB.next;
        }

        return null;
    }

    //Approach 2: Using two pointer technique. Faster than HashSet
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (ptrA != ptrB) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;
    }

}
