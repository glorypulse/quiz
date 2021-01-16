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
    public int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    int getDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        return Math.max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
    }
}
