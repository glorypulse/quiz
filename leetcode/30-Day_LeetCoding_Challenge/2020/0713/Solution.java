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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        
        pQueue.offer(p);
        qQueue.offer(q);
        
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();
            if (pNode == null && qNode == null) {
                continue;
            } else if (pNode != null && qNode == null ||
                pNode == null && qNode != null ||
                pNode.val != qNode.val) {
                return false;
            }

            pQueue.offer(pNode.left);
            pQueue.offer(pNode.right);
            qQueue.offer(qNode.left);
            qQueue.offer(qNode.right);
        }
        if (pQueue.isEmpty() && !qQueue.isEmpty() ||
            !pQueue.isEmpty() && qQueue.isEmpty()) {
            return false;
        }
        return true;
    }
}