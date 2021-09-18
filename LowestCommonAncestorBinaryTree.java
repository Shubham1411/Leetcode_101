/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
public class LowestCommonAncestorBinaryTree {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Approach : Using DFS recursively iterate through the left sub-tree and right sub-tree.
    //Time: 100 percentile. Space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //Return null if root is null
        if (root == null)
            return null;

        //Check if root.val is equal to p or q and return the node
        if (root.val == p.val || root.val == q.val) return root;

        //Recursively iterate the left sub-tree and right sub-tree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //If both left and right node are present return root
        if (left != null && right != null)
            return root;

        else if (left != null)
            return left;

        else
            return right;
    }

    public static void main(String[] args) {

    }
}
