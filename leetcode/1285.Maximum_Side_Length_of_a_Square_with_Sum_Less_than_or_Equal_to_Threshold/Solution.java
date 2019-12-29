class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        if (mat.length == 0) return 0;
        int n = mat.length;
        int m = mat[0].length;
        int size = Math.min(n, m);

        int[][][] memo = new int[n][m][size];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        int tmpSum;
        while (size >= 1) {
            for (int i = 0; i <= n - size; i ++) {
                for (int j = 0; j <= m - size; j ++) {
                    tmpSum = getSum(i, j, size, mat, memo);
                    if (tmpSum <= threshold) return size;
                }
            }
            size --;
        }
        return size;
    }

    int getSum(int i, int j, int size, int[][] mat, int[][][] memo) {
        if (memo[i][j][size - 1] >= 0) return memo[i][j][size - 1];
        if (size == 1) {
            memo[i][j][0] = mat[i][j];
            return memo[i][j][size - 1];
        }

        int sum = 0;
        int t;
        for (t = j; t < j + size; t ++) {
            sum += mat[i][t];
        }
        for (t = i + 1; t < i + size; t ++) {
            sum += mat[t][j];
        }

        sum += getSum(i + 1, j + 1, size - 1, mat, memo);
        memo[i][j][size - 1] = sum;
        return memo[i][j][size - 1];
    }
}
