class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        int n = length / 2;
        int[] minCost = new int[n + 1];
        minCost[0] = 0;

        for (int i = 1; i <= n; i ++) {
            minCost[i] += minCost[i - 1] + costs[i - 1][0];
        }

        for (int i = 1; i <= n; i ++) {
            minCost[0] += costs[i - 1][1];
            for (int j = 1; j <= n; j ++) {
                minCost[j] = Math.min(minCost[j - 1] + costs[j + i - 1][0],
                                      minCost[j] + costs[j + i - 1][1]);
            }
        }
        return minCost[n];
    }
}
