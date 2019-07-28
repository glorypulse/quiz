import java.util.Arrays;

class Solution {
    class UnionFind {
        int[] parents;
        int[] size;

        UnionFind(int length) {
            parents = new int[length];
            for (int i = 0; i < length; i ++) {
                parents[i] = i;
            }
            size = new int[length];
            Arrays.fill(size, 1);
        }

        int root(int i) {
            while (parents[i] != i) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int root_i = root(i);
            int root_j = root(j);
            if (root_i == root_j) return;
            if (size[root_i] < size[root_j]) {
                parents[root_i] = root_j;
                size[root_j] += size[root_i];
            } else {
                parents[root_j] = root_i;
                size[root_i] += size[root_j];
            }
        }

        int countPathSize() {
            int count = 0;
            boolean[] counted = new boolean[size.length];
            for (int i = 0; i < size.length; i ++) {
                int root_i = root(i);
                if (counted[root_i]) continue;
                counted[root_i] = true;
                count += size[root_i] - 1;
            }
            return count;
        }
    }

    public int removeStones(int[][] stones) {
        int length = stones.length;
        UnionFind uf = new UnionFind(length);
        for (int i = 0; i < length - 1; i ++) {
            for (int j = i + 1; j < length;  j ++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }

        return uf.countPathSize();
    }
}
