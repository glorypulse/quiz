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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) return cloned;
        TreeNode targetCopy = null;
        if (original.left != null) {
            targetCopy = getTargetCopy(original.left, cloned.left, target);
        }
        if (targetCopy != null) return targetCopy;
        if (original.right != null) {
            targetCopy = getTargetCopy(original.right, cloned.right, target);
        }
        return targetCopy;
    }
}
