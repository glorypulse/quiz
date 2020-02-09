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
    class TreeNodePlus {
        int val, leftTreeVal, rightTreeVal, allVal;
        TreeNodePlus left;
        TreeNodePlus right;
        TreeNodePlus(int x) { val = x; }
    }
    public int maxProduct(TreeNode root) {
        TreeNodePlus rootPlus = setTreeNodePlus(root);

        return (int)getMaxProduct(rootPlus, 0) % 1000000007;
    }

    TreeNodePlus setTreeNodePlus(TreeNode node) {
        TreeNodePlus nodePlus = new TreeNodePlus(node.val);
        if (node.left == null) {
            nodePlus.leftTreeVal = 0;
        } else {
            TreeNodePlus leftPlus = setTreeNodePlus(node.left);
            nodePlus.left = leftPlus;
            nodePlus.leftTreeVal = leftPlus.allVal;
        }

        if (node.right == null) {
            nodePlus.rightTreeVal = 0;
        } else {
            TreeNodePlus rightPlus = setTreeNodePlus(node.right);
            nodePlus.right = rightPlus;
            nodePlus.rightTreeVal = rightPlus.allVal;
        }

        nodePlus.allVal = nodePlus.val + nodePlus.leftTreeVal + nodePlus.rightTreeVal;
        return nodePlus;
    }

    long getMaxProduct(TreeNodePlus node, int parentsVal) {
        int val = parentsVal + node.val;
        long max = 0;
        if (node.left != null) {
            max = Math.max(max, (val + node.rightTreeVal) * node.leftTreeVal);
            max = Math.max(max, getMaxProduct(node.left, val + node.rightTreeVal));
        }
        if (node.right != null) {
            max = Math.max(max, (val + node.leftTreeVal) * node.rightTreeVal);
            max = Math.max(max, getMaxProduct(node.right, val + node.leftTreeVal));
        }
        return max;
    }
}
