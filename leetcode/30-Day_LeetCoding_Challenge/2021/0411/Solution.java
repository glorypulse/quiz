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
    public int deepestLeavesSum(TreeNode root) {
        ArrayList<Integer> sumList = new ArrayList<>();
        setSum(root, 1, sumList);
        return sumList.get(sumList.size() - 1);
    }

    void setSum(TreeNode node, int depth, ArrayList<Integer> sumList) {
        if (node == null) {
            return;
        }
        if (sumList.size() < depth) {
            sumList.add(node.val);
        } else {
            sumList.set(depth - 1, sumList.get(depth - 1) + node.val);
        }
        setSum(node.left, depth + 1, sumList);
        setSum(node.right, depth + 1, sumList);
    }
}
