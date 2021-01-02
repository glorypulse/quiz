class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] opCount = new int[n + 1][m + 1];
        opCount[n][m] = 0;
        for (int i = 0; i < n; i ++) {
            opCount[i][m] = n - i;
        }
        for (int i = 0; i < m; i ++) {
            opCount[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; i --) {
            for (int j = m - 1; j >= 0; j --) {
                opCount[i][j] = Math.min(opCount[i + 1][j + 1] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1),
                                         Math.min(opCount[i][j + 1] + 1,
                                                  opCount[i + 1][j] + 1));
            }
        }
        return opCount[0][0];
    }
}
