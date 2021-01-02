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
    class NodeData {
	int depth;
	TreeNode parentNode;

	NodeData(int depth, TreeNode parentNode) {
	    this.depth = depth;
	    this.parentNode = parentNode;
	}
    }

    NodeData check;
    
    public boolean isCousins(TreeNode root, int x, int y) {
	return getNodeData(root, x, y, 0, null);
    }

    boolean getNodeData(TreeNode node, int x, int y, int depth, TreeNode parent) {
	if (node == null) return false;
	if (node.val == x || node.val == y) {
	    if (check == null) {
		check = new NodeData(depth, parent);
	    } else {
		if (check.depth == depth && check.parentNode != parent) {
		    return true;
		}
		return false;
	    }
	}
	
	boolean ans = false;
	if (node.left != null) {
	    ans = getNodeData(node.left, x, y, depth + 1, node);
	}
	if (node.right != null) {
	    ans = ans || getNodeData(node.right, x, y, depth + 1, node);
	}
	return ans;
    }
}
