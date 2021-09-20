import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be
set to NULL.
Initially, all next pointers are set to NULL.

Constraints:
The number of nodes in the tree is in the range [0, 6000].
-100 <= Node.val <= 100
 */
public class PopulatingNextRightPointersEachNodeII {

    //Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //Approach 1: Using Queue and BFS. Add the root node to the queue. We need to declare a dummy node to point to each
    //level in the tree. We need to add the right and left children of the root to the queue.
    //Time: 1 ms, 68 percentile
    public Node connect1(Node root) {

        //if root is null return root
        if (root == null) {
            return root;
        }

        //Declare a queue and add the root node to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //loop till queue is not empty
        while (!queue.isEmpty()) {
            int size = queue.size();

            //declare a dummy node to point to each level and traverse across it
            Node dummy = new Node(0);

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                dummy.next = curr;
                dummy = dummy.next;

                if (curr.left != null)
                    queue.offer(curr.left);

                if (curr.right != null)
                    queue.offer(curr.right);
            }
        }
        return root;
    }

    //Approach 2: Using Parent pointer and Child pointers.
    //Time: 0ms, 100 percentile
    public Node connect2(Node root) {
        Node parent = root;
        Node child = null, childHead = null;

        //Traversing the tree vertically
        while (parent != null) {
            //Traversing the tree across each level
            while (parent != null) {
                if (parent.left != null) {
                    if (childHead == null) {
                        childHead = parent.left;
                    } else {
                        child.next = parent.left;
                    }
                    child = parent.left;
                }
                if (parent.right != null) {
                    if (childHead == null) {
                        childHead = parent.right;
                    } else {
                        child.next = parent.right;
                    }
                    child = parent.right;
                }
                parent = parent.next;
            }
            parent = childHead;
            childHead = child = null;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
