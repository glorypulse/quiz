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
class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        this.root.val = 0;
    }

    public boolean find(int target) {
        LinkedList<Integer> parentList = new LinkedList<>();

        int tmpTarget = target;
        parentList.addFirst(tmpTarget);
        while (tmpTarget > 2) {
            if (tmpTarget % 2 == 0) {
                tmpTarget = (tmpTarget - 1) / 2;
            } else {
                tmpTarget = tmpTarget / 2;
            }
            parentList.addFirst(tmpTarget);
        }

        TreeNode node = root;
        for (int parent: parentList) {
            if (node.left != null) {
                node.left.val = node.val * 2 + 1;
                if (node.left.val == parent) {
                    node = node.left;
                    continue;
                }
            }

            if (node.right != null) {
                node.right.val = node.val * 2 + 2;
                if (node.right.val == parent) {
                    node = node.right;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
