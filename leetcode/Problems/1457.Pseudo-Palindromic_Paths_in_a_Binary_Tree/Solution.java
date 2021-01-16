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
    public int pseudoPalindromicPaths (TreeNode root) {
        return countPPPaths(root, new boolean[10], 0);
    }

    int countPPPaths(TreeNode node, boolean[] numOdd, int oddCount) {
        int val = node.val;
        numOdd[val] = !numOdd[val];
        if (numOdd[val]) {
            oddCount ++;
        } else {
            oddCount --;
        }

        int count = 0;
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                count += countPPPaths(node.left, numOdd, oddCount);
            }
            if (node.right != null) {
                count += countPPPaths(node.right, numOdd, oddCount);
            }
        } else if (oddCount <= 1) {
            count ++;
        }

        // backtruck
        numOdd[val] = !numOdd[val];
        if (numOdd[val]) {
            oddCount ++;
        } else {
            oddCount --;
        }
        return count;
    }
}
