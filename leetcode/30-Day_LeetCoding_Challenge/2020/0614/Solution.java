class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList[] edges = new ArrayList[n];
        for (int i = 0; i < n; i ++) {
            edges[i] = new ArrayList<int[]>();
        }
        for (int[] flight: flights) {
            edges[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        int step = -1;
        while (step < K && !queue.isEmpty()) {
            int[] nextCosts = costs.clone();
            Queue<Integer> next = new LinkedList<>();
            for (int town: queue) {
                for (int[] edge: (ArrayList<int[]>)edges[town]) {
                    if (nextCosts[edge[0]] > costs[town] + edge[1]) {
                        nextCosts[edge[0]] = costs[town] + edge[1];
                        next.add(edge[0]);
                    }
                }
            }
            step ++;
            costs = nextCosts;
            queue = next;
        }
        if (costs[dst] == Integer.MAX_VALUE) return -1;
        return costs[dst];
    }
}
