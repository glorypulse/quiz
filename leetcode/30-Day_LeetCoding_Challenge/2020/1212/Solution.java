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
    class MinTree {
        TreeNode minNode;
        int depth;

        MinTree(TreeNode node, int depth) {
            this.minNode = node;
            this.depth = depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return getDeepestSubtree(root).minNode;
    }

    MinTree getDeepestSubtree(TreeNode node) {
        if (node == null) return new MinTree(null, 0);
        MinTree left = getDeepestSubtree(node.left);
        MinTree right = getDeepestSubtree(node.right);

        if (left.depth == right.depth) {
            return new MinTree(node, left.depth + 1);
        } else if (left.depth > right.depth) {
            left.depth += 1;
            return left;
        } else {
            right.depth += 1;
            return right;
        }
    }
}
