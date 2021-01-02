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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<int[]>> traversalMap = new TreeMap<>();
        traverseX(traversalMap, root, 0, 0);
        List<List<Integer>> traversalList = new ArrayList<>();
        for (PriorityQueue<int[]> valPQ: traversalMap.values()) {
            List<Integer> valList = new ArrayList<>();
            traversalList.add(valList);
            while (!valPQ.isEmpty()) {
                int[] val = valPQ.poll();
                valList.add(val[0]);
            }
        }
        return traversalList;
    }


    void traverseX(TreeMap<Integer, PriorityQueue<int[]>> traversalMap, TreeNode node, int x, int depth) {
        if (node == null) return;
        int[] coordinate = new int[2];
        coordinate[0] = node.val;
        coordinate[1] = depth;
        PriorityQueue<int[]> valPQ = traversalMap.get(x);
        if (valPQ == null) {
            valPQ = new PriorityQueue<>((a, b) -> {
                    if (a[1] != b[1]) return a[1] - b[1];
                    return a[0] - b[0];
            });
            traversalMap.put(x, valPQ);
        }
        valPQ.offer(coordinate);

        traverseX(traversalMap, node.left, x - 1, depth + 1);
        traverseX(traversalMap, node.right, x + 1, depth + 1);
    }
}
