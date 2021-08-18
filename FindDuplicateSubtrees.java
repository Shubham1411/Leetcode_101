import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given the root of a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with the same node values.

Constraints:
The number of the nodes in the tree will be in the range [1, 10^4]
-200 <= Node.val <= 200

 */


//Approach : Build a hashmap and put the node.val + left + right as key. Count the occurrence. If count == 2, that means
//it has duplicate , add that root node ot the final list. Do it recursively
//Time: O(n), 60 percentile
public class FindDuplicateSubtrees {

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

    Map<String, Integer> map;
    List<TreeNode> list;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        duplicate(root);
        return list;
    }

    public String duplicate(TreeNode node) {
        if (node == null)
            return "X";

        String left = duplicate(node.left);
        String right = duplicate(node.right);

        String s = Integer.toString(node.val) + "-" + left + "-" + right;

        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2)
            list.add(node);

        return s;
    }

    public static void main(String[] args) {

    }
}
