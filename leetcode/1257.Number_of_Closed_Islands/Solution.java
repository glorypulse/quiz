class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        if (grid.length == 0) return 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == 0 && checkIsland(i, j, grid, visited)) {
                    count ++;
                }
            }
        }
        return count;
    }

    boolean checkIsland(int i, int j, int[][] grid, boolean[][] visited) {
        if (grid[i][j] == 1) return true;
        if (grid[i][j] == 2) return false;
        if (visited[i][j]) return true;

        visited[i][j] = true;
        if (i - 1 < 0 || j - 1 < 0 || i + 1 >= grid.length || j + 1 >= grid[i].length) {
            grid[i][j] = 2;
            return false;
        }

        if(checkIsland(i + 1, j, grid, visited) &&
           checkIsland(i - 1, j, grid, visited) &&
           checkIsland(i, j + 1, grid, visited) &&
           checkIsland(i, j - 1, grid, visited)) {
            grid[i][j] = 1;
            return true;
        } else {
            grid[i][j] = 2;
            return false;
        }
    }
}
