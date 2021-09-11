import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
level by level).

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {

        //List of List to store the nodes of tree at same level and return the answer
        List<List<Integer>> res = new ArrayList<>();
        //Queue to implement the BFS
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return res;

        //Initially add the root to the queue
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                temp.add(curNode.val);

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
