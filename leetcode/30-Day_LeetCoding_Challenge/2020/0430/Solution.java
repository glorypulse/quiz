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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return checkValidSequence(0, root, arr);
    }

    boolean checkValidSequence(int index, TreeNode node, int[] arr) {
        if (node == null) return false;
        if (index == arr.length - 1) {
            if (arr[index] == node.val && node.right == null && node.left == null) return true;
            return false;
        }
        if (arr[index] == node.val) {
            return checkValidSequence(index + 1, node.right, arr) ||
                checkValidSequence(index + 1, node.left, arr);
        }
        return false;
    }
}
