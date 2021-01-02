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
    class NodeLevel {
      int level;
      int number;
      TreeNode node;
      
      NodeLevel(int level, TreeNode node, int number) {
        this.level = level;
        this.node = node;
        this.number = number;
      }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
      if (root == null) return 0;
      Queue<NodeLevel> queue = new LinkedList<>();
      
      queue.offer(new NodeLevel(0, root, 1));
      int minNum = Integer.MAX_VALUE;
      int maxNum = Integer.MIN_VALUE;
      int max = 0;
      int level = 0;
      
      while (!queue.isEmpty()) {
        NodeLevel nodeLevel = queue.poll();
        // level
        if (level != nodeLevel.level) {
          max = Math.max(max, maxNum - minNum + 1);
          level = nodeLevel.level;
          minNum = Integer.MAX_VALUE;
          maxNum = Integer.MIN_VALUE;         
        }
        
        TreeNode node = nodeLevel.node;
        int number = nodeLevel.number;
        if (node != null) {
          minNum = Math.min(minNum, number);
          maxNum = Math.max(maxNum, number);
          queue.offer(new NodeLevel(level + 1, node.left, 2 * number - 1));
          queue.offer(new NodeLevel(level + 1, node.right, 2 * number));
        }
      }
      return max;
    }
}