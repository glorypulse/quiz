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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> flipList = new ArrayList<>();
        if (flipMatch(root, voyage, flipList)) {
            return flipList;
        }
        //return flipList;
        return Arrays.asList(-1);
    }

    boolean flipMatch(TreeNode node, int[] voyage, List<Integer> flipList) {
        if (index == voyage.length || node == null) {
            return true;
        } else if (node.val != voyage[index]) {
            return false;
        }
        index ++;
        if (node.left == null || node.right == null ||
            index == voyage.length || node.left.val == voyage[index]) {
            return flipMatch(node.left, voyage, flipList) && flipMatch(node.right, voyage, flipList);
        } else if (node.right.val == voyage[index]) {
            flipList.add(node.val);
            return flipMatch(node.right, voyage, flipList) && flipMatch(node.left, voyage, flipList);
        }
        return false;
    }
}
