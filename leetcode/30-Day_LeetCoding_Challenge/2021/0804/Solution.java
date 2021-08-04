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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ansList = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        addPath(root, path, targetSum, ansList);
        return ansList;
    }

    void addPath(TreeNode node, LinkedList<Integer> path, int targetSum, List<List<Integer>> ansList) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) { // leaf
            if (targetSum == node.val) {
                ansList.add(new ArrayList(path));
            }
        } else {
            addPath(node.left, path, targetSum - node.val, ansList);
            addPath(node.right, path, targetSum - node.val, ansList);
        }
        path.removeLast();
    }
}
