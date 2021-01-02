class Solution {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        k = Math.min(k, length / 2);
        int[][] transactions = new int[k + 1][2];
        for (int i = 0; i <= k; i ++) {
            Arrays.fill(transactions[i], Integer.MIN_VALUE + 1000);
        }
        transactions[0][0] = 0;

        for (int i = 0; i < length; i ++) {
            int price = prices[i];
            int tmp = 0, prev = 0;
            for (int j = 0; j <= Math.min((i + 1) / 2, k); j ++) {
                if (j != 0) {
                    prev = tmp;
                    tmp = transactions[j][0];
                    transactions[j][0] = Math.max(tmp, prev + price);
                } else {
                    tmp = 0;
                }

                prev = tmp;
                tmp = transactions[j][1];
                transactions[j][1] = Math.max(tmp, prev - price);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i ++) {
            max = Math.max(max, Math.max(transactions[i][0], transactions[i][1]));
        }
        return max;
     }
}
