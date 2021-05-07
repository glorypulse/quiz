class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] distances = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= m; j ++) {
                char c2 = word2.charAt(j - 1);
                distances[i][j] = Math.max(distances[i][j - 1],
                                           Math.max(distances[i - 1][j],
                                                    distances[i - 1][j - 1] + (c1 == c2 ? 1 : 0)));
            }
        }
        return n + m - distances[n][m] * 2;
    }
}
