class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int[] memo = new int[4];
        Arrays.fill(memo, Integer.MIN_VALUE);

        // initialize
        for (int i = 0; i < Math.min(3, prices.length); i ++) {
            int price = prices[i];
            if (i > 1) {
                memo[2] = Math.max(memo[2], memo[1] - price);
            }
            if (i > 0) {
                memo[1] = Math.max(memo[1], memo[0] + price);
            }
            memo[0] = Math.max(memo[0], -price);
        }

        for (int i = 3; i < prices.length; i ++) {
            int price = prices[i];
            memo[3] = Math.max(memo[3], memo[2] + price);
            memo[2] = Math.max(memo[2], memo[1] - price);
            memo[1] = Math.max(memo[1], memo[0] + price);
            memo[0] = Math.max(memo[0], -price);
        }

        int max = 0;
        for (int i = 0; i < memo.length; i ++) {
            max = Math.max(max, memo[i]);
        }

        return max;
    }
}
