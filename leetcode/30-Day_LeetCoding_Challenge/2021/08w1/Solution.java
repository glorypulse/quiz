class Solution {
    class Edge {
        int i, j, weight;
        Edge(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int maxSize;
        int length;
        UnionFind(int length) {
            parents = new int[length];
            size = new int[length];
            this.length = length;
            for (int i = 0; i < length; i ++) {
                parents[i] = i;
                size[i] = 1;
            }
            maxSize = 1;
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[parents[x]]);
            }
            return parents[x];
        }

        void union(int x, int y) {
            int findX = find(x);
            int findY = find(y);
            if (findX == findY) return;
            parents[findX] = Math.min(findX, findY);
            parents[findY] = parents[findX];

            size[x] += size[y];
            size[y] = size[x];
            maxSize = Math.max(size[x], maxSize);
        }
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (int i = 0; i < n; i ++) {
            pq.offer(new Edge(0, i + 1, wells[i]));
        }
        for (int[] pipe: pipes) {
            pq.offer(new Edge(pipe[0], pipe[1], pipe[2]));
        }

        int cost = 0;
        UnionFind uf = new UnionFind(n + 1);
        while (!pq.isEmpty() && uf.maxSize <= n) {
            Edge edge = pq.poll();
            if (uf.find(edge.i) != uf.find(edge.j)) {
                uf.union(edge.i, edge.j);
                cost += edge.weight;
            }
        }

        return cost;
    }
}
