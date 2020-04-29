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
    class MaxSum {
        int pathMax;
        int treeMax;

        MaxSum(int pathMax, int treeMax) {
            this.pathMax = pathMax;
            this.treeMax = treeMax;
        }
    }
    public int maxPathSum(TreeNode root) {
        MaxSum rootSum = calcMaxSum(root);
        return rootSum.treeMax;
    }

    MaxSum calcMaxSum(TreeNode node) {
        if (node == null) {
            return new MaxSum(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        MaxSum rightSum = calcMaxSum(node.right);
        MaxSum leftSum = calcMaxSum(node.left);

        int pathMax = node.val;
        int treeMax = node.val;
        if (rightSum.pathMax > 0) {
            treeMax += rightSum.pathMax;
            pathMax += rightSum.pathMax;
        }
        if (leftSum.pathMax > 0) {
            treeMax += leftSum.pathMax;
            pathMax = Math.max(pathMax, node.val + leftSum.pathMax);
        }
        treeMax = Math.max(treeMax, Math.max(rightSum.treeMax, leftSum.treeMax));
        return new MaxSum(pathMax, treeMax);
    }
}
