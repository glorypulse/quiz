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
    int sumTilt = 0;
    public int findTilt(TreeNode root) {
        getSumWithCalcTilt(root);
        return sumTilt;
    }

    int getSumWithCalcTilt(TreeNode node) {
        if (node == null) return 0;

        int leftSum = getSumWithCalcTilt(node.left);
        int rightSum = getSumWithCalcTilt(node.right);

        // calc tilt
        sumTilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }
}
