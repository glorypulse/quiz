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
    public TreeNode balanceBST(TreeNode root) {
        int leftDepth = 0;
        leftDepth = countDepth(root.left, leftDepth);
    }

    int countDepth(TreeNode node, int count) {
        if (node == null) return count;
        return Math.max(countDepth(node.left, count + 1) , countDepth(node.right, count + 1));
    }
}
