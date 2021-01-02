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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.val == sum) count ++;

        if (root.left != null) {
            List<Integer> leftList = subPathSum(root.left, sum);
            for (int left: leftList) {
                int val = left + root.val;
                if (val == sum) count ++;
            }
        }
        if (root.right != null) {
            List<Integer> rightList = subPathSum(root.right, sum);
            for (int right: rightList) {
                int val = right + root.val;
                if (val == sum) count ++;
            }
        }
        return count;
    }

    List<Integer> subPathSum(TreeNode node, int target) {
        if (node.val == target) count ++;
        List<Integer> sumList = new ArrayList<>();
        sumList.add(node.val);

        if (node.left != null) {
            List<Integer> leftList = subPathSum(node.left, target);
            for (int left: leftList) {
                int val = left + node.val;
                if (val == target) count ++;
                sumList.add(val);
            }
        }
        if (node.right != null) {
            List<Integer> rightList = subPathSum(node.right, target);
            for (int right: rightList) {
                int val = right + node.val;
                if (val == target) count ++;
                sumList.add(val);
            }
        }
        return sumList;
    }
}
