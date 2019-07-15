import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> ancestorsP = new LinkedList<TreeNode>();
        LinkedList<TreeNode> ancestorsQ = new LinkedList<TreeNode>();

        searchAncestors(ancestorsP, root, p);
        searchAncestors(ancestorsQ, root, q);

        TreeNode target = root;
        TreeNode ancP = target, ancQ = target;
        while (!ancestorsP.isEmpty() && !ancestorsQ.isEmpty()) {
            ancP = ancestorsP.remove();
            ancQ = ancestorsQ.remove();
            if (ancP == ancQ) {
                target = ancP;
            }
        }
        return target;
    }

    boolean searchAncestors(LinkedList<TreeNode> ancestors, TreeNode node, TreeNode target) {
        if (node == null) return false;
        if (node.val == target.val) {
            ancestors.add(node);
            return true;
        }

        if (node.left == null && node.right == null) { // leaf
            return false;
        }
        ancestors.add(node);
        if (searchAncestors(ancestors, node.left, target) || searchAncestors(ancestors, node.right, target)) {
            return true;
        }
        ancestors.removeLast();
        return false;
    }
}
