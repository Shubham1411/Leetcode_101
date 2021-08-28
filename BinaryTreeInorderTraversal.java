import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

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

    //Approach 1: An Iterative approach using Stack and DFS. Start with the root node. Start checking the left node of
    //each root if that's null, add to list. Or else use DFSa nd push it onto stack. After traversing all the left nodes
    //Start with the right nodes.
    //Time: O(n), 100 percentile, 0ms. Space: O(n)
    public List<Integer> inorderTraversal1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        //Return if root is null
        if (root == null) return result;

        while (true) {
            //Push the root node onto stack if not null and then got to the left node
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                //break if the stack is empty
                if (stack.isEmpty()) break;
                //pop if root has no further nodes, pop it and add to result
                root = stack.pop();
                result.add(root.val);
                //now got to the right node
                root = root.right;
            }
        }
        return result;
    }

    //Approach 2: Using Recursive call, visit the left, root snd right
    //Time: O(n), 100 percentile, 0ms, Space: O(n)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static void main(String[] args) {

    }

}
