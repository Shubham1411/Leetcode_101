import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

 */
public class BinaryTreePreorderTraversal {


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

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                traversal(root.left, res);
            }
            if (root.right != null) {
                traversal(root.right, res);
            }
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        //Return if root is null
        if (root == null) return result;

        while (true) {
            //Push the root node onto stack if not null and then got to the left node
            if (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                //break if the stack is empty
                if (stack.isEmpty()) break;
                //pop if root has no further nodes, pop it and add to result
                root = stack.pop();

                //now got to the right node
                root = root.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
