class Solution {
    class UnionFind {
        int[] parents;

        UnionFind(int length) {
            parents = new int[length];
            for (int i = 0; i < length; i ++) {
                parents[i] = i;
            }
        }

        void union(int a, int b) {
            int ai = find(a);
            int bi = find(b);
            if (ai != bi) {
                int min = Math.min(ai, bi);
                parents[ai] = min;
                parents[bi] = min;
                parents[a] = min;
                parents[b] = min;
            }
        }

        int find(int a) {
            int i = a;
            while (parents[parents[i]] != parents[i]) {
                i = parents[parents[i]];
                parents[a] = i;
            }
            return parents[i];
        }
    }

    public int largestComponentSize(int[] A) {
        int max = 0;
        for (int a: A) {
            max = Math.max(max, a);
        }

        UnionFind uf = new UnionFind(max + 1);

        for (int a: A) {
            if (uf.parents[a] != a) continue;
            int min_factor = 1;
            Set<Integer> factors = new HashSet<>();
            for (int i = 2; i * i <= a; i ++) {
                if (a % i == 0) {
                    if (min_factor <= 1) {
                        min_factor = i;
                    }
                    factors.add(i);
                    factors.add(a / i);
                }
            }
            if (min_factor == 1) continue;
            for (int factor: factors) {
                uf.union(min_factor, factor);
            }
            uf.union(min_factor, a);
        }

        Map<Integer, Integer> componentMap = new HashMap<>();
        max = 0;
        for (int a: A) {
            int p = uf.find(a);
            int size = componentMap.getOrDefault(p, 0);
            componentMap.put(p, ++size);
            max = Math.max(max, size);
        }
        return max;
    }
}
