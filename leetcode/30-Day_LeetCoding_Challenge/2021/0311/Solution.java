class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[amount] = 0;
        Arrays.sort(coins);
        calcCoins(amount, coins, memo);
        if (memo[0] == Integer.MAX_VALUE) return -1;
        return memo[0];
    }

    int calcCoins(int amount, int[] coins, int[] memo) {
        if (amount == 0) return memo[0];
        for (int i = coins.length - 1; i >= 0; i --) {
            int remain = amount - coins[i];
            if (remain >= 0 && memo[remain] > memo[amount] + 1) {
                memo[remain] = memo[amount] + 1;
                calcCoins(remain, coins, memo);
            }
        }
        return -1;
    }
}
