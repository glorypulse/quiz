/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        setBstNode(preorder, 1, root, Integer.MAX_VALUE);
        return root;
    }

    int setBstNode(int[] preorder, int index, TreeNode node, int pVal) {
        if (index >= preorder.length) return index;
        int value = preorder[index];
        if (value < node.val) {
            TreeNode child = new TreeNode(value);
            node.left = child;
            index = setBstNode(preorder, index + 1, child, node.val);
            if (index >= preorder.length) return index;
            value = preorder[index];
        }
        if (value <= pVal) {
            TreeNode child = new TreeNode(value);
            node.right = child;
            index = setBstNode(preorder, index + 1, child, pVal);
        }
        return index;
    }
}
