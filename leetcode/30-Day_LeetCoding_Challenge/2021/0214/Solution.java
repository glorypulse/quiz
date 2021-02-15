class Solution {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        boolean[] visited = new boolean[length];
        boolean[][] sets = new boolean[2][length];
        for (int i = 0; i < length; i ++) {
            if (visited[i]) continue;
            sets[0][i] = true;
            if (!isBipartite(i, graph, visited, sets)) return false;
        }
        return true;
    }

    boolean isBipartite(int v, int[][] graph, boolean[] visited, boolean[][] sets) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            int index = 0;
            if (sets[0][cur]) {
                index = 0;
            } else if (sets[1][cur]) {
                index = 1;
            } else {
                index = 0;
                sets[0][cur] = true;
            }
            for (int con: graph[cur]) {
                if (sets[index][con]) {
                    return false;
                } else if (!sets[index ^ 1][con]) {
                    sets[index ^ 1][con] = true;
                    queue.offer(con);
                }
            }
        }
        return true;
    }
}
