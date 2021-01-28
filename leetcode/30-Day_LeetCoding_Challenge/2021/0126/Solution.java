class Solution {
    class Node {
        int effort;
        int i;
        int j;

        Node(int effort, int i, int j) {
            this.effort = effort;
            this.i = i;
            this.j = j;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        int m = heights[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        int[][] efforts = new int[n][m];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        pq.offer(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.effort >= efforts[n - 1][m - 1]) break;
            int i = node.i;
            int j = node.j;
            int height = heights[i][j];
            int effort = efforts[i][j];
            setMinEffortPath(i - 1, j, heights, efforts, height, effort, pq);
            setMinEffortPath(i + 1, j, heights, efforts, height, effort, pq);
            setMinEffortPath(i, j - 1, heights, efforts, height, effort, pq);
            setMinEffortPath(i, j + 1, heights, efforts, height, effort, pq);
        }

        return efforts[n - 1][m - 1];
    }

    void setMinEffortPath(int i, int j, int[][] heights, int[][] efforts, int pHeight, int pEffort, PriorityQueue<Node> pq) {
        if (i < 0 || j < 0 || i >= efforts.length || j >= efforts[0].length || pEffort >= efforts[i][j]) {
            return;
        }
        int effort = Math.abs(heights[i][j] - pHeight);
        if (effort >= efforts[i][j]) {
            return;
        }
        efforts[i][j] = Math.max(pEffort, effort);
        pq.offer(new Node(efforts[i][j], i, j));
    }
}
