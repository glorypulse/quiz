class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        int nega_col = m;

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (j == nega_col) {
                    count += m - j;
                    break;
                }
                if (grid[i][j] < 0) {
                    count += m - j;
                    nega_col = j;
                    break;
                }
            }
            if (nega_col == 0) {
                count += (n - i - 1) * m;
                break;
            }
        }

        return count;
    }
}
