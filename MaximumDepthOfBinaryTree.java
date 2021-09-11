/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest
leaf node.

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {

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

    //Approach 1: Bottom up approach to recursive call the function the child nodes and calculate the depth of the root
    //node with the answer returned from the child nodes
    public int maxDepth(TreeNode root) {

        //Return 0 if the root node is null
        if (root == null)
            return 0;

        //Return 1 if the root node is a leaf node
        if (root.left == null && root.right == null)
            return 1;

        //Calculate the depth of left child
        int left_depth = maxDepth(root.left);
        //Calculate the depth of right child
        int right_depth = maxDepth(root.right);

        //Return max of left depth and right depth + 1
        return Math.max(left_depth, right_depth) + 1;
    }

    public static void main(String[] args) {

    }
}
