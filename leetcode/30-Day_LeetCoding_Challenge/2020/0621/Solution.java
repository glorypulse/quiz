class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        if (n == 0) return 1;
        int m = dungeon[0].length;
        int[][] healthPoint = new int[n][m];
        healthPoint[n - 1][m - 1] = Math.max(1, 1- dungeon[n - 1][m - 1]);
        for (int i = n - 2; i >= 0; i --) {
            healthPoint[i][m - 1] = Math.max(1, healthPoint[i + 1][m - 1] - dungeon[i][m - 1]);
        }
        for (int i = m - 2; i >= 0; i --) {
            healthPoint[n - 1][i] = Math.max(1, healthPoint[n - 1][i + 1] - dungeon[n - 1][i]);
        }

        for (int i = n - 2; i >= 0; i --) {
            for (int j = m - 2; j >= 0; j --) {
                healthPoint[i][j] = Math.max(1,
                                             Math.min(healthPoint[i + 1][j], healthPoint[i][j + 1]) - dungeon[i][j]);
            }
        }

        return healthPoint[0][0];
    }
}
