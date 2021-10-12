/*
You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node
does not exist, return null.
 */
public class SearchBinarySearchTree {

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

    //Approach : Solving the problem recursively. Check if root.val == val return the root. Else if val is < root.val,
    //search in the left subtree or else in the right subtree.
    //Time: O(n), 100 percentile, Space: O(n)
    public TreeNode searchBST(TreeNode root, int val) {

        if (root.val == val) return root;

        else if (val < root.val) {
            if (root.left == null) {
                return null;
            } else {
                return searchBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                return null;
            } else {
                return searchBST(root.right, val);
            }
        }
    }

    public static void main(String[] args) {

    }
}
