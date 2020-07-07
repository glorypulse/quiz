class Solution {
    public int islandPerimeter(int[][] grid) {
      int n = grid.length;
      if (n == 0) return 0;
      int m = grid[0].length;
      
      boolean[][] visited = new boolean[n][m];
      int count = 0;
      for (int i = 0; i < n; i ++) {
        for (int j = 0; j < m; j ++) {
          if (grid[i][j] == 1) {
            count = countPerimeter(grid, i, j, visited);
            break;
          }
        }
        if (count != 0) break;
      }
      return count;
    }
    
    int countPerimeter(int[][] grid, int i, int j, boolean[][] visited) {
      if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 1;
      if (visited[i][j]) return 0;
      if (grid[i][j] == 0) return 1;
      
      visited[i][j] = true;
      return countPerimeter(grid, i + 1, j, visited) +
        countPerimeter(grid, i, j + 1, visited) +
        countPerimeter(grid, i - 1, j, visited) +
        countPerimeter(grid, i, j - 1, visited);
    }
}