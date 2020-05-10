class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] parents = new int[n];
        for (int[] edge: edges) {
            parents[edge[1]] = edge[0];
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        int time = 0;
        int index = 0;
        for (boolean apple: hasApple) {
            if (apple) {
                time += countTime(parents, visited, index);
            }
            index ++;
        }
        return time;
    }

    int countTime(int[] parents, boolean[] visited, int index) {
        if (!visited[index]) {
            visited[index] = true;
            return 2 + countTime(parents, visited, parents[index]);
        } else {
            return 0;
        }
    }
}
