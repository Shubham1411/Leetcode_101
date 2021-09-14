/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
public class PathSum {

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

    //Approach 1: Using DFS, and top-down approach. Each time subtract the root.val from the targetSum and pass it onto
    //the child nodes. At the leaf node check if root.val == targetSum
    //Time: 23 percentile
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && root.val == targetSum)
            return true;

        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    //Approach 2: Same as above approach
    //Time: 100 percentile
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        targetSum -= root.val;

        if (root.left == null && root.right == null)
            return targetSum == 0;

        return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);
    }

    public static void main(String[] args) {

    }
}
