class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int[] no_stock = new int[2];
        int[] one_stock = new int[2];
        int[] next_idle = new int[2];

        no_stock[0] = 0;
        one_stock[0] = -prices[0];
        next_idle[0] = Integer.MIN_VALUE;

        for (int i = 1; i < length; i ++) {
            int price = prices[i];
            int index = i % 2;
            int prev_index = (i - 1) % 2;
            no_stock[index] = Math.max(no_stock[prev_index], next_idle[prev_index]);
            one_stock[index] = Math.max(one_stock[prev_index], no_stock[prev_index] - price);
            next_idle[index] = one_stock[prev_index] + price;
        }
        int index = (length - 1) % 2;
        return Math.max(no_stock[index], Math.max(one_stock[index], next_idle[index]));
    }
}
