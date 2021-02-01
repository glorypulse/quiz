/* Vertical Order Traversal of a Binary Tree */
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
    class Node {
        TreeNode treeNode;
        int col;
        Node(TreeNode node, int col) {
            this.treeNode = node;
            this.col = col;
        }
    }

    class PQNode {
        int col;
        int row;
        int val;

        PQNode(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<PQNode> pq = new PriorityQueue<>((a, b) -> {
                if (a.col != b.col) {
                    return a.col - b.col;
                } else if (a.row != b.row) {
                    return a.row - b.row;
                }
                return a.val - b.val;
        });
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        int row = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            row ++;
            for (int i = 0; i < size; i ++) {
                Node node = queue.poll();
                int col = node.col;
                TreeNode treeNode = node.treeNode;
                pq.offer(new PQNode(col, row, treeNode.val));
                if (treeNode.left != null) {
                    queue.offer(new Node(treeNode.left, col - 1));
                }
                if (treeNode.right != null) {
                    queue.offer(new Node(treeNode.right, col + 1));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int col = pq.peek().col;
            List<Integer> ansList = new ArrayList<>();
            while (!pq.isEmpty() && col == pq.peek().col) {
                ansList.add(pq.poll().val);
            }
            ans.add(ansList);
        }
        return ans;
    }
}
