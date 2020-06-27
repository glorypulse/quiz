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
    public int sumNumbers(TreeNode root) {
        return sumPaths(root, 0);
    }

    int sumPaths(TreeNode node, int parentSum) {
        if (node == null) return parentSum;
        int val = node.val + 10 * parentSum;
        if (node.left == null && node.right == null) return val;

        int sum = 0;
        if (node.left != null) {
            sum += sumPaths(node.left, val);
        }

        if (node.right != null) {
            sum += sumPaths(node.right, val);
        }
        return sum;
    }
}
