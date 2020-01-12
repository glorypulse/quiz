/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> elements = new ArrayList<>();
        addNodeValue(root1, elements);
        addNodeValue(root2, elements);
        Collections.sort(elements);

        return elements;
    }

    void addNodeValue(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        addNodeValue(root.left, list);
        addNodeValue(root.right, list);
    }
}
