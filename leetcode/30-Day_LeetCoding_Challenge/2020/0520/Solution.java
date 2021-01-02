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
    int index = 0;
    TreeNode ans;
    public int kthSmallest(TreeNode root, int k) {
        getKth(root, k);
        return ans.val;
    }

    void getKth(TreeNode node, int k) {
        if (node.left != null) {
            getKth(node.left, k);
            if (index == k) return;
        }
        index ++;
        if (index == k) {
            ans = node;
            return;
        }
        if (node.right != null) {
            getKth(node.right, k);
        }
        return;
    }
}
