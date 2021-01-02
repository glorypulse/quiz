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
    class MaxPair {
        int pathMax;
        int diameter;

        MaxPair(int pathMax, int diameter) {
            this.pathMax = pathMax;
            this.diameter = diameter;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return countChildPath(root).diameter;
    }

    MaxPair countChildPath(TreeNode node) {
        if (node == null) return new MaxPair(0, 0);
        MaxPair left = new MaxPair(0, 0), right = new MaxPair(0, 0);
        if (node.left != null) {
            left = countChildPath(node.left);
            left.pathMax += 1;
        }
        if (node.right != null) {
            right = countChildPath(node.right);
            right.pathMax += 1;
        }
        return new MaxPair(Math.max(left.pathMax, right.pathMax),
                           Math.max(left.pathMax + right.pathMax,
                                    Math.max(left.diameter, right.diameter)));
    }
}
