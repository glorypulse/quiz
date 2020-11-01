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
    public void recoverTree(TreeNode root) {
        swapNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode swapNode(TreeNode node, int lower, int upper) {
        if (node == null) return null;
        TreeNode invalidNodeLeft = swapNode(node.left, lower, node.val);
        TreeNode invalidNodeRight = swapNode(node.right, node.val, upper);

        if (invalidNodeLeft != null && node.val > upper) return invalidNodeLeft;
        if (invalidNodeRight != null && node.val < lower) return invalidNodeRight;
        if (node.val < lower || node.val > upper) return node;

        if (invalidNodeLeft != null && invalidNodeRight != null) {
            swap(invalidNodeLeft, invalidNodeRight);
            return null;
        } else if (invalidNodeLeft != null) {
            if (invalidNodeLeft.val < upper && invalidNodeLeft.val > node.val) {
                swap(node, invalidNodeLeft);
                return null;
            }
            return invalidNodeLeft;
        } else if (invalidNodeRight != null) {
            if (invalidNodeRight.val > lower && invalidNodeRight.val < node.val) {
                swap(node, invalidNodeRight);
                return null;
            }
            return invalidNodeRight;
        }
        return null;
    }

    void swap(TreeNode nodeA, TreeNode nodeB) {
        int tmp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = tmp;
    }
}
