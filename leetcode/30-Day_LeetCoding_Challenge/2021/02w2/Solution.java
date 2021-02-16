class Solution {
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Map<Integer, List<int[]>> islands = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count += isNewIslands(i, j, grid, islands, visited) ? 1 : 0;
                }
            }
        }

        return count;
    }

    boolean isNewIslands(int i, int j, int[][] grid, Map<Integer, List<int[]>> islands, boolean[][] visited) {
        int num = numIslands(i, j, grid, visited);
        List<int[]> islandsList = islands.get(num);
        if (islandsList == null) {
            islandsList = new ArrayList<>();
            islands.put(num, islandsList);
        } else {
            for (int[] island: islandsList) {
                if (checkSameIslands(i, j, island[0], island[1], grid, new boolean[grid.length][grid[0].length])) {
                    return false;
                }
            }
        }
        islandsList.add(new int[]{ i, j });
        return true;
    }

    int numIslands(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]) return 0;
        visited[i][j] = true;
        if (grid[i][j] == 0) return 0;
        return 1 + numIslands(i - 1, j, grid, visited) +
            numIslands(i + 1, j, grid, visited) +
            numIslands(i, j - 1, grid, visited) +
            numIslands(i, j + 1, grid, visited);
    }

    boolean checkSameIslands(int i, int j, int s, int t, int[][] grid, boolean[][] visited) {
        int orig = 1;
        int comp = 1;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            orig = 0;
        } else if (visited[i][j]) {
            return true;
        } else {
            visited[i][j] = true;
            if (grid[i][j] == 0) {
                orig = 0;
            }
        }
        if (s < 0 || t < 0 || s >= grid.length || t >= grid[0].length) {
            comp = 0;
        } else if (visited[s][t]) {
            return true;
        } else {
            visited[s][t] = true;
            if (grid[s][t] == 0) {
                comp = 0;
            }
        }

        if (orig != comp) {
            return false;
        } else if (orig == 0) {
            return true;
        }
        return checkSameIslands(i - 1, j, s - 1, t, grid, visited) &&
            checkSameIslands(i + 1, j, s + 1, t, grid, visited) &&
            checkSameIslands(i, j - 1, s, t - 1, grid, visited) &&
            checkSameIslands(i, j + 1, s, t + 1, grid, visited);
    }
}
