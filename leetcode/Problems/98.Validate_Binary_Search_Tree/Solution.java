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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);

    }

    boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        return greaterThan(node.val, min) && lessThan(node.val, max) &&
            isValid(node.left, min, node.val) &&
            isValid(node.right, node.val, max);
    }

    boolean greaterThan(int value, Integer target) {
        if (target == null) return true;
        return value > target;
    }

    boolean lessThan(int value, Integer target) {
        if (target == null) return true;
        return value < target;
    }
}
