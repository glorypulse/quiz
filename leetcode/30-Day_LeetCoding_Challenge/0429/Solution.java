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
            return new MaxSum(0, Integer.MIN_VALUE);
        }

        MaxSum rightSum = calcMaxSum(node.right);
        MaxSum leftSum = calcMaxSum(node.left);

        int treeMax = node.val + rightSum.pathMax + leftSum.pathMax;
        int pathMax = Math.max(node.val + rightSum.pathMax, node.val + leftSum.pathMax);

        treeMax = Math.max(treeMax, Math.max(rightSum.treeMax, leftSum.treeMax));
        return new MaxSum(Math.max(0, pathMax), treeMax);
    }
}
