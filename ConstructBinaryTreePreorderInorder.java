import java.util.HashMap;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is
the inorder traversal of the same tree, construct and return the binary tree.

Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */

//Approach : Store the values and indexes of the Inorder traversal in a HashMap for searching them in O(1) time. Then
//recursively iterate the preorder and inorder arrays. The 1st index of the preorder will be the root node, find its
//index in the inorder, left side of the index will be left child and right side of the index will be right child
//In recursion we 1st use root, then left subtree and then right, since PRE(Root, Left, Right) and we are traversing
//from forward direction of preorder.
//Time: 98 percentile
public class ConstructBinaryTreePreorderInorder {

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

    //Index to store the length and map to store the index of inorder traversal
    HashMap<Integer, Integer> hash = new HashMap<>();
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //Store the indexes and values in hashmap
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }

        return helper(inorder, preorder, 0, preorder.length - 1);

    }

    public TreeNode helper(int[] inorder, int[] preorder, int start, int end) {

        if (start > end)
            return null;

        TreeNode node = new TreeNode(preorder[index++]);

        int mid = hash.get(node.val);

        node.left = helper(inorder, preorder, start, mid - 1);
        node.right = helper(inorder, preorder, mid + 1, end);

        return node;

    }

}
