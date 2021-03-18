class Solution {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if (length == 0) return 0;
        int[] memo = new int[2];
        memo[1] = -prices[0];
        for (int i = 1; i < length; i ++) {
            int[] cur = new int[2];
            cur[0] = Math.max(memo[0], memo[1] + prices[i] - fee);
            cur[1] = Math.max(memo[1], memo[0] - prices[i]);
            memo = cur;
        }
        return memo[0];
    }
}
