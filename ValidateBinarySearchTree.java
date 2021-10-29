/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */
public class ValidateBinarySearchTree {

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

    //Approach : Using recursion to validate the root.val should be more than root.left and less than root.right
    //Time: O(n), space: O(n)
    public boolean isValidBST(TreeNode root) {

        //CheckBST validates the range of the root.val, if it is between the upper and lower bound
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean checkBST(TreeNode root, long left, long right) {

        //If root is null, it is leave node, by default a BST
        if (root == null)
            return true;

        //if root.val is less than left node or more than right node return false
        if (root.val <= left || root.val >= right)
            return false;

        //Call the checkBST recursively
        return checkBST(root.left, left, root.val) && checkBST(root.right, root.val, right);

    }

    public static void main(String[] args) {

    }
}
