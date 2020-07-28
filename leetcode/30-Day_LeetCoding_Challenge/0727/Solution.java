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
    int inorder_index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;

        if (length == 0) return null;
        TreeNode root = null;
        if (inorder[0] == postorder[0]) {
            root = new TreeNode(inorder[0]);
            index ++;
        }
        if (length == 1) return root;
        root = makeTree(inorder, postorder, index, index, length, root);
        return root;
    }

    TreeNode makeTree(int[] inorder, int[] postorder, int in_i, int post_i, int length, TreeNode left) {
        if (in_i >= inorder.length || post_i >= length) return left;
        TreeNode right = null;
        int tmp_i = in_i;
        int tmp_p = post_i;

        while (tmp_p < length && inorder[tmp_i] != postorder[tmp_p]) {
            tmp_p ++;
        }

        if (tmp_p == post_i + 1 && tmp_p < length) {
            right = new TreeNode(postorder[post_i]);
            tmp_i ++;
            post_i ++;
        } else if (post_i == tmp_p || tmp_i + 1 >= inorder.length) {
            right = null;
        } else {
            if (inorder[tmp_i + 1] == postorder[post_i]) {
                right = new TreeNode(inorder[tmp_i + 1]);
                tmp_i ++;
                post_i ++;
            }
            right = makeTree(inorder, postorder, tmp_i + 1, post_i, tmp_p, right);
        }

        index = Math.max(index, tmp_p + 1);
        inorder_index = Math.max(inorder_index, tmp_i + 1);

        if (index < length) {
            return makeTree(inorder, postorder, Math.max(inorder_index, index), tmp_p + 1, length, new TreeNode(inorder[in_i], left, right));
        }
        return new TreeNode(inorder[in_i], left, right);
    }
}
