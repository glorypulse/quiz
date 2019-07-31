import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    class UnionFind {
        int[] parents;
        int[] size;

        UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i ++) {
                parents[i] = i;
            }
            Arrays.fill(size, 1);
        }

        int root(int i) {
            if (parents[i] != i) parents[i] = root(parents[i]);
            return parents[i];
        }

        void union(int i, int j) {
            int rootI = root(i);
            int rootJ = root(j);

            if (rootI == rootJ) return;
            if (size[rootI] < size[rootJ]) {
                parents[rootI] = rootJ;
            } else {
                parents[rootJ] = rootI;
            }
        }
    }

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(20000);
        Set<Integer> pointSet = new HashSet<Integer>();
        for (int[] stone: stones) {
            uf.union(stone[0], stone[1] + 10000);
            pointSet.add(stone[0]);
            pointSet.add(stone[1] + 10000);
        }
        Set<Integer> rootSet = new HashSet<Integer>();
        for (int point: pointSet) {
            rootSet.add(uf.root(point));
        }

        return stones.length - rootSet.size();

    }
}
