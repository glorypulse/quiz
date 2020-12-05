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
    class NodePointer {
        TreeNode top;
        TreeNode last;

        NodePointer(TreeNode top, TreeNode last) {
            this.top = top;
            this.last = last;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        return orderIncreasing(root).top;
    }

    NodePointer orderIncreasing(TreeNode node) {
        TreeNode top = null, last = null;
        if (node.left != null) {
            NodePointer leftPointer = orderIncreasing(node.left);
            top = leftPointer.top;
            leftPointer.last.right = node;
            node.left = null;
        } else {
            top = node;
        }

        if (node.right != null) {
            NodePointer rightPointer = orderIncreasing(node.right);
            last = rightPointer.last;
            node.right = rightPointer.top;
        } else {
            last = node;
        }

        return new NodePointer(top, last);
    }
}
