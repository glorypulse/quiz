class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parents = new int[n];
        for (int i = 0; i < n; i ++) {
            parents[i] = i;
        }

        int p, c, tmp;
        for (int[] connection: connections) {
            p = Math.min(connection[0], connection[1]);
            c = Math.max(connection[0], connection[1]);
            while (parents[c] != c) {
                if (parents[c] < p) {
                    tmp = p;
                    p = parents[c];
                    c = tmp;
                } else {
                    tmp = c;
                    c = parents[c];
                    parents[tmp] = p;
                }
            }
            parents[c] = p;
        }

        for (int i = 1; i < n; i ++) {
            while (parents[parents[i]] != parents[i]) {
                parents[i] = parents[parents[i]];
            }
        }

        Set<Integer> countSet = new HashSet<>();
        for (int parent: parents) {
            countSet.add(parent);
        }

        return countSet.size() - 1;
    }
}
