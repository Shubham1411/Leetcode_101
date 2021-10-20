import java.util.LinkedList;
import java.util.Queue;

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
    //node with the answer returned from the child nodes (DFS)
    //Time: O(n) 0ms, Space: O(n)
    public int maxDepth1(TreeNode root) {

        //Return 0 if the root node is null
        if (root == null)
            return 0;

        //Return 1 if the root node is a leaf node
        if (root.left == null && root.right == null)
            return 1;

        //Calculate the depth of left child
        int left_depth = maxDepth1(root.left);
        //Calculate the depth of right child
        int right_depth = maxDepth1(root.right);

        //Return max of left depth and right depth + 1
        return Math.max(left_depth, right_depth) + 1;
    }

    //Approach 2: Solving it iteratively using queue.Not an optimized approach.
    public int maxDepth2(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();

        nodes.offer(root);
        depths.offer(1);

        int currentDepth = 0, maxDepth = 0;

        while (!nodes.isEmpty()) {

            TreeNode node = nodes.poll();
            currentDepth = depths.poll();

            if (node != null) {
                maxDepth = Math.max(currentDepth, maxDepth);
                nodes.offer(node.left);
                nodes.offer(node.right);
                depths.offer(currentDepth + 1);
                depths.offer(currentDepth + 1);
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {

    }
}
