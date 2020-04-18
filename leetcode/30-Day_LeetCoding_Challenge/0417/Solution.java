class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == '1') {
                    count ++;
                    markIslands(i, j, grid);
                }
            }
        }
        return count;
    }

    void markIslands(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] != '1') return;
        grid[i][j] = '2';
        markIslands(i - 1, j, grid);
        markIslands(i + 1, j, grid);
        markIslands(i, j - 1, grid);
        markIslands(i, j + 1, grid);
    }
}
