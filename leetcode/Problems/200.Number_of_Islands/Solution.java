class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        boolean[][] touched = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (touched[i][j]) continue;
                if (grid[i][j] == '1') {
                    // found an island!
                    count++;
                    foundIsland(grid, touched, i, j);
                } else {
                    touched[i][j] = true;
                }
            }
        }
        return count;
    }

    private void foundIsland(char[][] grid, boolean[][] touched, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || touched[i][j]) return;
        touched[i][j] = true;
        if (grid[i][j] == '0') return;
        if (grid[i][j] == '1') {
            // right
            foundIsland(grid, touched, i, j + 1);
            // down
            foundIsland(grid, touched, i + 1, j);
            // left
            foundIsland(grid, touched, i, j - 1);
            // up
            foundIsland(grid, touched, i - 1, j);
        }
        return;
    }
}
