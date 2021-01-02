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
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> exists = new HashSet<>();
        return countPalindromicPaths(root, exists);
    }

    int countPalindromicPaths (TreeNode node, Set<Integer> exists) {
        if (node == null) {
            return 0;
        }

        toggleExistsSet(exists, node.val);

        int countSum = 0;
        if (node.left == null && node.right == null) { // leaf
            if (exists.size() <= 1) {
                countSum += 1;
            }
        } else {
            countSum += countPalindromicPaths(node.left, exists) +
                countPalindromicPaths(node.right, exists);

        }
        toggleExistsSet(exists, node.val);

        return countSum;
    }

    void toggleExistsSet(Set<Integer> exists, int val) {
        if (exists.contains(val)) {
            exists.remove(val);
        } else {
            exists.add(val);
        }
    }
}
