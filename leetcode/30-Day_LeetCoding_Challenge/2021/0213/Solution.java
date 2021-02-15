class Solution {
    int[] directions = new int[] { -1, 0, 1 };
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int count = 1;
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ 0, 0 });
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] current = queue.poll();
                if (current[0] == n - 1 && current[1] == n - 1) {
                    return count;
                }
                for (int s = 0; s < 3; s ++) {
                    for (int t = 0; t < 3; t ++) {
                        setNextPath(current[0] + directions[s], current[1] + directions[t],
                                    grid, visited, queue);
                    }
                }
            }
            count ++;
        }
        return -1;
    }

    void setNextPath(int i, int j, int[][] grid, boolean[][] visited, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || visited[i][j]) return;
        visited[i][j] = true;
        if (grid[i][j] == 1) return;
        queue.offer(new int[] { i, j });
    }
}
