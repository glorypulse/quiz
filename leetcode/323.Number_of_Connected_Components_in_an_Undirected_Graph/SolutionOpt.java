class Solution {
    class UnionFind {
        int[] parents;
        int[] sz;
        int count;

        UnionFind(int n) {
            parents = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i ++) {
                parents[i] = i;
                sz[i] = 1;
            }
            count = n;
        }

        void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (i == j) return;
            if (sz[i] < sz[j]) {
                parents[i] = j;
                sz[j] += sz[i];
            } else {
                parents[j] = i;
                sz[i] += sz[j];
            }
            count --;
        }

        int root(int p) {
            int i = p;
            while (parents[i] != i) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.count;
    }
}
