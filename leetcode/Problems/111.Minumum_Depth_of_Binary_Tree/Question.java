/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayDeque;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        ArrayDeque<TreeNode> currentQueue = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> nextQueue = new ArrayDeque<TreeNode>();
        int depth = 1;
        currentQueue.add(root);

        while (!currentQueue.isEmpty()) {
            TreeNode current = currentQueue.remove();
            if (current.left == null && current.right == null) break;
            if (current.left != null) nextQueue.add(current.left);
            if (current.right != null) nextQueue.add(current.right);

            if (currentQueue.isEmpty()) {
                currentQueue = nextQueue;
                nextQueue = new ArrayDeque<TreeNode>();
                depth += 1;
            }
        }

        return depth;
    }
}
