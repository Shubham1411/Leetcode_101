/*
A binary tree is uni-valued if every node in the tree has the same value.
Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 */
public class UnivaluedBinaryTree {

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

    //Approach : Recursively check if value of the root node is equal to its left and right node
    //Time: 0ms, 100 percentile
    public boolean isUnivalTree(TreeNode root) {
        boolean leftValue = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean rightValue = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return leftValue && rightValue;
    }

    public static void main(String[] args) {

    }
}
