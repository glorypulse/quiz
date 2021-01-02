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
    int count = 0;
    boolean found = false;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        this.count = 1;
        TreeNode node = root;
        int maxH = 1;
        while (node != null) {
            count += 1 << maxH;
            maxH ++;
            node = node.right;
        }

        decLeaf(root, maxH, 1);
        return this.count;
    }


    void decLeaf(TreeNode node, int maxH, int h) {
        if (found) return;

        if (h < maxH) {
            decLeaf(node.right, maxH, h + 1);
            decLeaf(node.left, maxH, h + 1);
        } else {
            if (node == null) {
                this.count --;
            } else {
                found = true;
                return;
            }
        }
        return;
    }
}
