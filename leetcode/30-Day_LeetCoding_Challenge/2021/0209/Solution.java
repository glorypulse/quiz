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
    public TreeNode convertBST(TreeNode root) {
        sumBST(root, 0);
        return root;
    }

    int sumBST(TreeNode node, int parentVal) {
        if (node == null) return parentVal;
        node.val += sumBST(node.right, parentVal);
        return sumBST(node.left, node.val);
    }
}
