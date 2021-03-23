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
    int index;
    String s;
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        index = 0;
        this.s = s;
        return makeNode();
    }

    TreeNode makeNode() {
        TreeNode node = new TreeNode();
        char c = s.charAt(index++);
        boolean minus = false;
        if (c == '-') {
            minus = true;
            c = s.charAt(index++);
        }
        node.val = c - '0';
        while (index < s.length()) {
            c = s.charAt(index++);
            if (c >= '0') {
                node.val = (node.val * 10) + (c - '0');
            } else {
                break;
            }
        }
        if (minus) {
            node.val = -node.val;
        }

        if (index >= s.length()) return node;
        if (c == '(') {
            node.left = makeNode();
            if (index >= s.length()) return node;
            c = s.charAt(index++);
            if (c == '(') {
                node.right = makeNode();
                index ++;
            }
        }
        return node;
    }
}
