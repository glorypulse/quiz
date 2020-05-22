class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] countMatrix = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 1) {
                    if (i - 1 < 0 || j - 1 < 0) {
                        countMatrix[i][j] = 1;
                    } else {
                        countMatrix[i][j] = Math.min(Math.min(countMatrix[i - 1][j], countMatrix[i][j - 1]), countMatrix[i - 1][j - 1]) + 1;
                    }
                    count += countMatrix[i][j];
                }
            }
        }
        return count;
    }
}
