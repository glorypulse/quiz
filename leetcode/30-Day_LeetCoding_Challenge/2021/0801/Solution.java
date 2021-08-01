class Solution {
    int[][] directions = new int[][] {
        { 1, 0 },
        { -1, 0 },
        { 0, 1 },
        { 0, -1 },
    };
    public int largestIsland(int[][] grid) {
        int length = grid.length;
        boolean[][] visited = new boolean[length][length];
        int[] islandArray = new int[length * 501];
        int[] parents = new int[length * 501];
        int max = 0;

        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j ++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int hash = i + j * 500;
                    islandArray[hash] = searchIsland(grid, hash, i, j, visited, parents);
                    max = Math.max(max, islandArray[hash]);
                }
            }
        }


        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j ++) {
                if (grid[i][j] == 0) {
                    Set<Integer> parentSet = new HashSet<>();
                    int sum = 0;
                    for (int[] direction: directions) {
                        int parentHash = getParentHash(i + direction[0], j + direction[1], length, parents, grid);
                        if (parentHash < 0 || parentSet.contains(parentHash)) continue;
                        parentSet.add(parentHash);
                        sum += islandArray[parentHash];
                    }
                    max = Math.max(max, sum + 1);
                }
            }
        }
        return max;
    }

    int getParentHash(int i, int j, int length, int[] parents, int[][] grid) {
        if (i < 0 || j < 0 || i >= length || j >= length || grid[i][j] == 0) return -1;
        int hash = i + j * 500;
        return parents[hash];
    }

    int searchIsland(int[][] grid, int hash, int i, int j, boolean[][] visited, int[] parents) {
        int length = grid.length;
        if (i < 0 || j < 0 || i >= length || j >= length || visited[i][j] || grid[i][j] == 0) return 0;
        visited[i][j] = true;
        parents[i + j * 500] = hash;
        return 1 + searchIsland(grid, hash, i + 1, j, visited, parents) +
            searchIsland(grid, hash, i - 1, j, visited, parents) +
            searchIsland(grid, hash, i, j + 1, visited, parents) +
            searchIsland(grid, hash, i, j - 1, visited, parents);
    }
}
