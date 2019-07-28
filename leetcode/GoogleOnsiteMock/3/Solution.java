import java.util.Set;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delSet = new HashSet<>();
        ArrayDeque<TreeNode> delNodes = new ArrayDeque<>();
        for (int del: to_delete) {
            delSet.add(del);
        }

        List<TreeNode> ret = new ArrayList<>();
        startDelNodes(root, delSet, delNodes, ret);

        TreeNode node;
        while (!delNodes.isEmpty()) {
            node = delNodes.poll();

            startDelNodes(node.left, delSet, delNodes, ret);
            startDelNodes(node.right, delSet, delNodes, ret);
        }

        return ret;
    }

    void startDelNodes(TreeNode node, Set<Integer> delSet, ArrayDeque<TreeNode> delNodes, List<TreeNode> ret) {
        if (node != null) {
            if (delSet.contains(node.val)) {
                delNodes.add(node);
                delSet.remove(node.val);
            } else {
                ret.add(node);
                getDelNodes(node, delSet, delNodes);
            }
        }
    }

    void getDelNodes(TreeNode node, Set<Integer> delSet, ArrayDeque<TreeNode> delNodes) {
        if (delSet.isEmpty()) return;
        TreeNode left = node.left;
        if (left != null) {
            if (delSet.contains(left.val)) {
                delNodes.add(left);
                delSet.remove(left.val);
                node.left = null;
            } else {
                getDelNodes(left, delSet, delNodes);
            }
        }
        TreeNode right = node.right;
        if (right != null) {
            if (delSet.contains(right.val)) {
                delNodes.add(right);
                delSet.remove(right.val);
                node.right = null;
            } else {
                getDelNodes(right, delSet, delNodes);
            }
        }
    }
}
