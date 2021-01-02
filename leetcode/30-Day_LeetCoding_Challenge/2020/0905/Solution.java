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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> list1 = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();

        traverseTreeToList(root1, list1);
        traverseTreeToList(root2, list2);

        List<Integer> allElementsList = new ArrayList<>();

        Integer val1 = null;
        Integer val2 = null;
        while (val1 != null || val2 != null || !list1.isEmpty() || !list2.isEmpty()) {
            if (val1 == null && !list1.isEmpty()) {
                val1 = list1.poll();
            }
            if (val2 == null && !list2.isEmpty()) {
                val2 = list2.poll();
            }

            if (val2 == null || val1 != null && val1 <= val2) {
                allElementsList.add(val1);
                val1 = null;
            } else {
                allElementsList.add(val2);
                val2 = null;
            }
        }
        return allElementsList;
    }

    void traverseTreeToList(TreeNode node, Queue<Integer> list) {
        if (node == null) return;

        traverseTreeToList(node.left, list);
        list.add(node.val);
        traverseTreeToList(node.right, list);
    }
}
