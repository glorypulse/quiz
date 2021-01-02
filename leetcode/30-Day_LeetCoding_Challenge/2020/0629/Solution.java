class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathNums = new int[n][m];
        pathNums[n - 1][m - 1] = 1;
        for (int i = n - 2; i >= 0; i --) {
            pathNums[i][m - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i --) {
            pathNums[n - 1][i] = 1;
        }

        for (int i = n - 2; i >= 0; i --) {
            for (int j = m - 2; j >= 0; j --) {
                pathNums[i][j] = pathNums[i + 1][j] + pathNums[i][j + 1];
            }
        }
        return pathNums[0][0];
    }
}
