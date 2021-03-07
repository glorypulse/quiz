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
    class Level {
        int count;
        long sum;

        Level(int val) {
            this.count = 1;
            this.sum = val;
        }

        Double getAverage() {
            return (sum + 0.0) / count;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Level> list = new ArrayList<>();
        setNodeList(root, 1, list);
        List<Double> averageList = list.stream()
            .map(Level::getAverage)
            .collect(Collectors.toList());
        return averageList;
    }

    void setNodeList(TreeNode node, int depth, ArrayList<Level> list) {
        if (node == null) return;
        if (list.size() < depth) {
            list.add(new Level(node.val));
        } else {
            Level level = list.get(depth - 1);
            level.count ++;
            level.sum += node.val;
        }
        setNodeList(node.left, depth + 1, list);
        setNodeList(node.right, depth + 1, list);
    }
}
