/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes
of the first two lists.

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    ListNode newHead = null;

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

    //Approach 1: Using 2 pointers technique and using merge sort technique
    //Time: O(n+m) Space: O(1)
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;

        ListNode ptr1 = l1, ptr2 = l2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                addAtTail(ptr1.val);
                ptr1 = ptr1.next;
            } else {
                addAtTail(ptr2.val);
                ptr2 = ptr2.next;
            }
        }

        while (ptr1 != null) {
            addAtTail(ptr1.val);
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            addAtTail(ptr2.val);
            ptr2 = ptr2.next;
        }

        return newHead;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (newHead == null) newHead = node;
        else {
            ListNode curr = newHead;
            while (curr.next != null)
                curr = curr.next;

            curr.next = node;
        }
    }

    //Approach 2: Using Recursion technique
    //Time: O(n+m) Space: O(n+m)
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }

    //Approach 3: Another iterative approach. Using a dummy node.
    //Time: O(n+m) Space: O(1)
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
