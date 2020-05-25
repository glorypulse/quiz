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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;
        makeBst(preorder, 1, root, Integer.MAX_VALUE);
        return root;
    }

    int makeBst(int[] preorder, int index, TreeNode node, int parent) {
        if (index == preorder.length) {
            return index;
        }
        int val = node.val;
        int next = preorder[index];
        if (next < val) {
            node.left = new TreeNode(next);
            index = makeBst(preorder, index + 1, node.left, val);
            if (index == preorder.length) {
                return index;
            }
            next = preorder[index];
        }

        if (next > val && next < parent) {
            node.right = new TreeNode(next);
            index = makeBst(preorder, index + 1, node.right, parent);
        }
        return index;
    }
}
