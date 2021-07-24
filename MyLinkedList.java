/*
Design and Implementation of Linked List
 */
public class MyLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    /* Initialize your data structure here. */
    public MyLinkedList() {

    }

    /* Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) return -1;

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /* Add a node of value val before the first element of the linked list. After the insertion, the new node
    will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    /* Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) head = node;
        else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;

            curr.next = node;
        }
        size++;
    }

    /* Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     list, the node will be appended to the end of linked list. If index is greater than the length, the node will not
      be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node node = new Node(val);
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    /* Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
    }

    //Display the linked list
    public void display() {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }

    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();

        obj.addAtHead(3);
        obj.addAtHead(4);
        obj.addAtTail(5);
        obj.addAtIndex(1, 6);
        obj.display();
    }
}
