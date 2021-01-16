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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeTargetLeaf(root, target);
    }

    TreeNode removeTargetLeaf(TreeNode node, int target) {
        if (node == null) return null;
        node.left = removeTargetLeaf(node.left, target);
        node.right = removeTargetLeaf(node.right, target);

        if (node.left == null && node.right == null
            && node.val == target) {
            return null;
        }
        return node;
    }

}
