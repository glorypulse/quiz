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
    class RobbedMoney {
        int robbed;
        int notRobbed;

        RobbedMoney() {}
        RobbedMoney(int robbed, int notRobbed) {
            this.robbed = robbed;
            this.notRobbed = notRobbed;
        }

        int max() {
            return Math.max(robbed, notRobbed);
        }
    }
    public int rob(TreeNode root) {
        return calcMoney(root).max();
    }

    RobbedMoney calcMoney(TreeNode node) {
        if (node == null) return new RobbedMoney(0, 0);
        RobbedMoney leftMoney = calcMoney(node.left);
        RobbedMoney rightMoney = calcMoney(node.right);
        return new RobbedMoney(leftMoney.notRobbed + rightMoney.notRobbed + node.val,
                               leftMoney.max() + rightMoney.max());

    }
}
