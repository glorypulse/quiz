class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[31];
        Arrays.fill(memo, Integer.MIN_VALUE);

        int prev = days[0];
        memo[1] = - costs[0];
        memo[7] = - costs[1];
        memo[30] = - costs[2];

        for (int i = 1; i < days.length; i ++) {
            int diff = days[i] - prev;

            memo[0] = Integer.MIN_VALUE;
            for (int j = 1; j <= Math.min(diff, 30); j ++) {
                int cur = Math.max(j - diff, 0);
                memo[cur] = Math.max(memo[cur], memo[j]);
            }
            for (int j = diff + 1; j < 31; j ++) {
                int cur = j - diff;
                memo[cur] = memo[j];
            }
            for (int j = Math.max(1, 31 - diff); j < 31; j ++) {
                memo[j] = Integer.MIN_VALUE;
            }

            memo[1] = Math.max(memo[1], memo[0] - costs[0]);
            memo[7] = Math.max(memo[7], memo[0] - costs[1]);
            memo[30] = Math.max(memo[30], memo[0] - costs[2]);
            prev = days[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 31; i ++) {
            max = Math.max(max, memo[i]);
        }

        return - max;
    }
}
