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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode dummy = new TreeNode(0, root, null);
        setNode(dummy, v, d - 1);
        return dummy.left;
    }

    void setNode(TreeNode node, int v, int d) {
        if (node == null) return;

        if (d <= 0) {
            node.left = new TreeNode(v, node.left, null);
            node.right = new TreeNode(v, null, node.right);
        } else {
            setNode(node.left, v, d - 1);
            setNode(node.right, v, d - 1);
        }
    }
}
