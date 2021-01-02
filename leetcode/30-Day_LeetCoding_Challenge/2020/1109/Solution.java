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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return maxDiff(root, root.val, root.val);
    }

    int maxDiff(TreeNode node, int min, int max) {
        if (node == null) return 0;
        int abs = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));

        int leftAbs = maxDiff(node.left, Math.min(min, node.val), Math.max(max, node.val));
        int rightAbs = maxDiff(node.right, Math.min(min, node.val), Math.max(max, node.val));

        return Math.max(abs, Math.max(leftAbs, rightAbs));
    }



}
