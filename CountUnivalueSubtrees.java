/*
Description:
Given a binary tree, count the number of uni-value subtrees.
A Uni-value subtree means all nodes of the subtree have the same value.
 */
public class CountUnivalueSubtrees {

    //Definition of TreeNode:
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    //Counter to count the number of univalued subtrees
    private int count = 0;

    //Approach : Using DFS and recursively check if root == root.left == root.right and DFS is used to navigate from leaf
    //to root node. 92 percentile in LintCode
    public int countUnivalSubtrees(TreeNode root) {
        DFS(root);
        return count;
    }

    private boolean DFS(TreeNode node) {

        //if it is leaf node it will be uni-valued so return true
        if (node == null) {
            return true;
        }

        //Check if left and right both are uni-valued subtrees
        boolean left = DFS(node.left);
        boolean right = DFS(node.right);

        if (left && right) {
            if ((node.left != null && node.left.val != node.val) ||
                    (node.right != null && node.right.val != node.val))
                return false;

            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
