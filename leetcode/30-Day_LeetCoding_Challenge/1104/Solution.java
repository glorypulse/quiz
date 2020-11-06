class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) return new ArrayList<>() {
                {
                    add(0);
                }
            };

        ArrayList<Integer>[] neighbors = new ArrayList[n];
        for (int i = 0; i < n; i ++) {
            neighbors[i] = new ArrayList<>();
        }
        int[] edgeCounts = new int[n];
        for (int[] edge: edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
            edgeCounts[edge[0]] ++;
            edgeCounts[edge[1]] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            if (edgeCounts[i] == 1) { // i.e. leaf
                queue.offer(i);
            }
        }

        int numVertices = n;
        while (numVertices > 2) {
            int numLeaf = queue.size();
            numVertices -= numLeaf;
            while (numLeaf-- > 0) {
                int leaf = queue.poll();
                for (int i: neighbors[leaf]) {
                    if (--edgeCounts[i] == 1) {
                        queue.offer(i);
                    }
                }
            }
        }

        List<Integer> minHeightTrees = new ArrayList<>();
        while (!queue.isEmpty()) {
            minHeightTrees.add(queue.poll());
        }
        return minHeightTrees;
    }
}
