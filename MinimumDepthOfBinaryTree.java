/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Constraints:
The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 */
public class MinimumDepthOfBinaryTree {

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

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {

    }
}
