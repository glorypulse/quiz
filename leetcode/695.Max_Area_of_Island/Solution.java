class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        boolean[][] touched = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (touched[i][j]) continue;
                if (grid[i][j] == 1) {
                    int area = foundIsland(grid, touched, i, j);
                    if (maxArea < area) {
                        maxArea = area;
                    }
                } else {
                    touched[i][j] = true;
                }
            }
        }
        return maxArea;
    }

    private int foundIsland(int[][] grid, boolean[][] touched, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || touched[i][j]) return 0;
        touched[i][j] = true;
        if (grid[i][j] == 1) {
            return 1 +
                foundIsland(grid, touched, i, j + 1) +
                foundIsland(grid, touched, i, j - 1) +
                foundIsland(grid, touched, i + 1, j) +
                foundIsland(grid, touched, i - 1, j);
        }
        return 0;
    }
}
