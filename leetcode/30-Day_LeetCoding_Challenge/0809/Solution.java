class Solution {
    final int MAX_DISTANCE = 100;

    public int orangesRotting(int[][] grid) {
        int n = grid.length; // 1 <= n <= 10
        int m = grid[0].length; // 1 <= m <= 100
        int[][] memo = new int[n][m];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == 2) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = MAX_DISTANCE;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == 2) {
                    updateRotting(grid, memo, i - 1, j);
                    updateRotting(grid, memo, i, j - 1);
                    updateRotting(grid, memo, i + 1, j);
                    updateRotting(grid, memo, i, j + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, memo[i][j]);
                }
            }
        }

        if (max == MAX_DISTANCE) return -1;
        return max;
    }

    void updateRotting(int[][] grid, int[][] memo, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return;

        int initial = memo[i][j];
        int val = initial;
        if (i > 0) {
            val = Math.min(val, memo[i - 1][j] + 1);
        }
        if (j > 0) {
            val = Math.min(val, memo[i][j - 1] + 1);
        }
        if (i < memo.length - 1) {
            val = Math.min(val, memo[i + 1][j] + 1);
        }
        if (j < memo[0].length - 1) {
            val = Math.min(val, memo[i][j + 1] + 1);
        }
        val = Math.min(val, MAX_DISTANCE);

        if (initial > val) {
            memo[i][j] = val;
            updateRotting(grid, memo, i - 1, j);
            updateRotting(grid, memo, i, j - 1);
            updateRotting(grid, memo, i + 1, j);
            updateRotting(grid, memo, i, j + 1);
        }
    }
}
