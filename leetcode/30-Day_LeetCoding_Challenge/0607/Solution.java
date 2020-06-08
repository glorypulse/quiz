class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        int[][] memo = new int[amount + 1][coins.length];
        for (int i = 0; i <= amount; i ++) {
            Arrays.fill(memo[i], -1);
        }
        return calcAmount(amount, coins, 0, memo);
    }

    int calcAmount(int amount, int[] coins, int index, int[][] memo) {
        if (amount < 0) {
            return 0;
        } else if (amount == 0) {
            return 1;
        } else if (memo[amount][index] != -1) {
            return memo[amount][index];
        }

        int count = 0;
        for (int i = index; i < coins.length; i ++) {
            int coin = coins[i];
            count += calcAmount(amount - coin, coins, i, memo);
        }

        return memo[amount][index] = count;
    }
}
