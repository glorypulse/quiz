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
class BSTIterator {
    Stack<TreeNode> nodeStack;
    TreeNode nextNode;

    public BSTIterator(TreeNode root) {
        nodeStack = new Stack<>();
        nextNode = getNextNode(root);
    }

    public int next() {
        int ans = nextNode.val;
        if (nextNode.right == null) {
            if (nodeStack.isEmpty()) {
                nextNode = null;
            } else {
                nextNode = nodeStack.pop();
            }
        } else {
            nextNode = getNextNode(nextNode.right);
        }
        return ans;
    }

    public boolean hasNext() {
        return nextNode != null;
    }

    private TreeNode getNextNode(TreeNode node) {
        if (node == null || node.left == null) {
            return node;
        }

        nodeStack.push(node);
        return getNextNode(node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
