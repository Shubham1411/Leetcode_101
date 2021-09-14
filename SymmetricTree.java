import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center)

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */
public class SymmetricTree {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Approach 1: Using BFS and Queue. Start traversing the tree and check node1.left == node2.right and node1.right ==
    //node2.left. Runtime: 1ms. Runtime beats only 30 percentile of the solution
    public boolean isSymmetric1(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        //Initially add the left and right of root node into the queue
        queue.offer(root.left);
        queue.offer(root.right);

        //Loop till the queue is empty
        while (!queue.isEmpty()) {

            TreeNode firstNode = queue.poll();
            TreeNode secondNode = queue.poll();

            //if it is a leaf node
            if (firstNode == null && secondNode == null) continue;

            if (firstNode == null && secondNode != null) return false;

            if (firstNode != null && secondNode == null) return false;

            //If the val is equal push into queue in order node1.left, node2.right, node1.right and node2.left
            if (firstNode.val == secondNode.val) {
                queue.offer(firstNode.left);
                queue.offer(secondNode.right);
                queue.offer(firstNode.right);
                queue.offer(secondNode.left);
            } else {
                return false;
            }

        }
        return true;
    }

    //Approach 2: Using a recursive solution. Time: 0ms, 100 percentile
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode nodeLeft, TreeNode nodeRight) {

        if (nodeLeft == null && nodeRight == null) return true;

        else if ((nodeLeft != null && nodeRight == null) ||
                (nodeLeft == null && nodeRight != null) ||
                (nodeLeft.val != nodeRight.val)) return false;

        else
            return (isSymmetricHelper(nodeLeft.left, nodeRight.right) && isSymmetricHelper(nodeLeft.right, nodeRight.left));
    }

    public static void main(String[] args) {

    }
}
