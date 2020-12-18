/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }

    boolean isValid(TreeNode node) {
        if (node == null) return true;
        if (node.left != null && !isValid(node.left)) return false;
        if (prev != null && prev >= node.val) return false;
        prev = node.val;
        if (node.right != null && !isValid(node.right)) return false;
        return true;
    }
}
