/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (checkSubPath(head, root)) {
            return true;
        }
        return checkSubPathNode(head, root);
    }

    boolean checkSubPathNode(ListNode target, TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return false;
        }
        if (node.left != null && checkSubPath(target, node.left)) {
            return true;
        }
        if (node.right != null && checkSubPath(target, node.right)) {
            return true;
        }
        return checkSubPathNode(target, node.left) || checkSubPathNode(target, node.right);
    }


    boolean checkSubPath(ListNode target, TreeNode node) {
        if ((target != null && node == null) ||
            target.val != node.val) return false;
        if (target.next == null) return true;

        return (checkSubPath(target.next, node.left) ||
                checkSubPath(target.next, node.right));
    }

}
