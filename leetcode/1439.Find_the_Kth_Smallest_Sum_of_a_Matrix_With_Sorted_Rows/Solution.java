class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        if (mat.length == 0) return 0;
        int n = mat[0].length;

        PriorityQueue<Integer> sumK = new PriorityQueue<>();
        for (int j = 0; j < n; j ++) {
            sumK.offer(mat[0][j]);
        }

        for (int i = 1; i < m; i ++) {
            PriorityQueue<Integer> nextSumK = new PriorityQueue<>();
            while (!sumK.isEmpty()) {
                int sum = sumK.poll();
                for (int j = 0; j < n; j ++) {
                    nextSumK.offer(sum + mat[i][j]);
                }
            }

            for (int l = 0; !nextSumK.isEmpty() && l < k; l ++) {
                sumK.offer(nextSumK.poll());
            }
        }

        for (int l = 0; l < k - 1; l ++) {
            sumK.poll();
        }
        return sumK.poll();
    }
}
