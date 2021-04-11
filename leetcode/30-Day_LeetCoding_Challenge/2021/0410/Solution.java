class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] paths  = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                max = Math.max(max, countLongestPath(i, j, -1, matrix, paths));
            }
        }
        return max;
    }

    int countLongestPath(int i, int j, int prev, int[][] matrix, int[][] paths) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length ||
            matrix[i][j] <= prev) {
            return 0;
        }
        if (paths[i][j] > 0) {
            return paths[i][j];
        }

        int count = 1;
        count += Math.max(countLongestPath(i + 1, j, matrix[i][j], matrix, paths),
                          Math.max(countLongestPath(i - 1, j, matrix[i][j], matrix, paths),
                                   Math.max(countLongestPath(i, j + 1, matrix[i][j], matrix, paths),
                                            countLongestPath(i, j - 1, matrix[i][j], matrix, paths))));
        paths[i][j] = count;
        return paths[i][j];
    }
}
