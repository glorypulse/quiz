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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        TreeMap<Integer, List<Integer>> levelMap = new TreeMap<>(Collections.reverseOrder());

        setLevelMap(root, levelMap, 0);
        List<List<Integer>> levelOrderList = new ArrayList<>();
        levelMap.forEach((key, value) -> {
                levelOrderList.add(value);
            });
        return levelOrderList;
    }

    void setLevelMap(TreeNode node, TreeMap<Integer, List<Integer>> levelMap, int level) {
        if (node == null) return;
        List<Integer> levelList = levelMap.get(level);
        if (levelList == null) {
            levelList = new ArrayList<>();
            levelMap.put(level, levelList);
        }
        levelList.add(node.val);
        setLevelMap(node.left, levelMap, level + 1);
        setLevelMap(node.right, levelMap, level + 1);
    }
}
