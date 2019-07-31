class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] maxPathMemo = new int[n][m];
        int path, max = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                path = maxPath(i, j, matrix, maxPathMemo);
                if (max < path) max = path;
            }
        }
        return max;
    }

    int maxPath(int i, int j, int[][] matrix, int[][] maxPathMemo) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) return 0;
        if (maxPathMemo[i][j] != 0) return maxPathMemo[i][j];
        int maxPath = 1;
        int nextMaxPath = 0;
        int value = matrix[i][j];
        if (i - 1 >= 0 && value < matrix[i - 1][j]) {
            nextMaxPath = maxPath(i - 1, j, matrix, maxPathMemo);
            if (maxPath < nextMaxPath + 1) {
                maxPath = nextMaxPath + 1;
            }
        }
        if (j - 1 >= 0 && value < matrix[i][j - 1]) {
            nextMaxPath = maxPath(i, j - 1, matrix, maxPathMemo);
            if (maxPath < nextMaxPath + 1) {
                maxPath = nextMaxPath + 1;
            }
        }
        if (i + 1 < n && value < matrix[i + 1][j]) {
            nextMaxPath = maxPath(i + 1, j, matrix, maxPathMemo);
            if (maxPath < nextMaxPath + 1) {
                maxPath = nextMaxPath + 1;
            }
        }
        if (j + 1 < m && value < matrix[i][j + 1]) {
            nextMaxPath = maxPath(i, j + 1, matrix, maxPathMemo);
            if (maxPath < nextMaxPath + 1) {
                maxPath = nextMaxPath + 1;
            }
        }
        maxPathMemo[i][j] = maxPath;
        return maxPath;
    }
}
