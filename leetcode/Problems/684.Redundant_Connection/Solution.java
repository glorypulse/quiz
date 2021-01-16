class Solution {
    class UnionFind {
        int[] parents;

        UnionFind(int length) {
            parents = new int[length];
            for (int i = 0; i < length; i ++) {
                parents[i] = i;
            }
        }

        int root(int i) {
            if (i != parents[i]) {
                parents[i] = root(parents[i]);
            }
            return parents[i];
        }

        boolean union(int i, int j) {
            int root_i = root(i);
            int root_j = root(j);
            if (root_i == root_j) return false;

            parents[root_i] = root_j;
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge: edges) {
            if (!uf.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return edges[0];
    }
}
