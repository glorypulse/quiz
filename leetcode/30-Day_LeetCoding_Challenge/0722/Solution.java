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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<LinkedList<Integer>> zigzagList = new ArrayList<>();
        setZigzagList(0, root, zigzagList);
        List<List<Integer>> ansList = new ArrayList<>();
        for (LinkedList<Integer> zigzagLs: zigzagList) {
            ansList.add(zigzagLs);
        }
        return ansList;
    }

    void setZigzagList(int depth, TreeNode node, List<LinkedList<Integer>> zigzagList) {
        if (node == null) return;
        LinkedList<Integer> list = null;
        if (zigzagList.size() == depth) {
            list = new LinkedList<>();
            zigzagList.add(list);
        } else {
            list = zigzagList.get(depth);
        }

        if (depth % 2 == 0) {
            list.add(node.val);
        } else {
            list.addFirst(node.val);
        }

        setZigzagList(depth + 1, node.left, zigzagList);
        setZigzagList(depth + 1, node.right, zigzagList);
    }
}
