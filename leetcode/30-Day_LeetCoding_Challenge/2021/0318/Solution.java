class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        int[][] memo = new int[length][2];
        Arrays.fill(memo[0], 1);

        int max = 1;
        for (int i = 1; i < length; i ++) {
            int j = i - 1;
            int val = nums[i];
            Arrays.fill(memo[i], 1);
            while (j >= 0) {
                if (nums[j] < val) {
                    memo[i][1] = Math.max(memo[i][1], memo[j][0] + 1);
                } else if (nums[j] > val) {
                    memo[i][0] = Math.max(memo[i][0], memo[j][1] + 1);
                }
                j --;
            }
            max = Math.max(max, Math.max(memo[i][0], memo[i][1]));
        }
        return max;
    }
}
