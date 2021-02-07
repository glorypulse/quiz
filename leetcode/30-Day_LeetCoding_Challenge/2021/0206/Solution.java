/**
 * Binary Tree Right Side View
 *
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sideList = new ArrayList<>();
        setRightSideView(root, sideList, 1);
        return sideList;
    }

    void setRightSideView(TreeNode node, List<Integer> sideList, int depth) {
        if (node == null) return;
        if (depth > sideList.size()) {
            sideList.add(node.val);
        }
        setRightSideView(node.right, sideList, depth + 1);
        setRightSideView(node.left, sideList, depth + 1);
    }
}
