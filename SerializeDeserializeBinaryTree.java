import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization
/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and
this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily
need to follow this format, so please be creative and come up with different approaches yourself.

Constraints:
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 */
public class SerializeDeserializeBinaryTree {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Approach 1: Using BFS and using Queue
    //Time: O(n), 44 percentile Space: O(n)

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = que.poll();

                if (curr.val != 2000) {
                    res.append(curr.val + ",");

                    if (curr.left != null)
                        que.offer(curr.left);
                    else
                        que.offer(new TreeNode(2000));

                    if (curr.right != null)
                        que.offer(curr.right);
                    else
                        que.offer(new TreeNode(2000));
                } else {
                    res.append("*,");
                }
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        System.out.println(data);

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        boolean isLeft = true;
        TreeNode node = null;
        for (int i = 1; i < values.length; i++) {
            if (isLeft) {
                node = q.poll();
                if (values[i].equals("*")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(values[i]));
                    q.offer(node.left);
                }
            } else {
                if (values[i].equals("*")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(values[i]));
                    q.offer(node.right);
                }
            }
            isLeft = !isLeft;
        }
        return root;
    }

    //Approach 2: Recursively solving the problem
    //Time: 44 percentile, Space: 0(1)

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) return "X,";

        String left = serialize2(root.left);
        String right = serialize2(root.right);

        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    public TreeNode deserializeHelper(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("X")) return null;

        TreeNode newNode = new TreeNode(Integer.parseInt(value));

        newNode.left = deserializeHelper(nodes);
        newNode.right = deserializeHelper(nodes);

        return newNode;
    }

    //Approach 3: Recursively solving this problem and using StringBuilder instead of String
    // Encodes a tree to a single string.
    public String serialize3(TreeNode root) {
        StringBuilder res = new StringBuilder();

        serialize3(root, res);
        return res.toString();
    }

    public void serialize3(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("#,");
            return;
        }

        res.append(root.val);
        res.append(",");
        serialize3(root.left, res);
        serialize3(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize3(String data) {
        LinkedList<String> strList = new LinkedList(Arrays.asList(data.split(",")));
        return buildTree(strList);
    }

    public TreeNode buildTree(LinkedList<String> strList) {

        String first = strList.removeFirst();
        if (first.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(first));

        root.left = buildTree(strList);
        root.right = buildTree(strList);

        return root;
    }

    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
        // Codec ser = new Codec();
        // Codec deser = new Codec();
        // TreeNode ans = deser.deserialize(ser.serialize(root));
    }
}
