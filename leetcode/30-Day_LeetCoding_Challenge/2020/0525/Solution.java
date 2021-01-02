class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;

        int[][] dp = new int[aLen][bLen];
        dp[0][0] = A[0] == B[0] ? 1 : 0;

        for (int i = 1; i < aLen; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], A[i] == B[0] ? 1 : 0);
        }
        for (int i = 1; i < bLen; i ++) {
            dp[0][i] = Math.max(dp[0][i - 1], A[0] == B[i] ? 1 : 0);
        }

        for (int i = 1; i < aLen; i ++) {
            for (int j = 1; j < bLen; j ++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + (A[i] == B[j] ? 1 : 0),
                                    Math.max(dp[i - 1][j],
                                             dp[i][j - 1]));
            }
        }

        return dp[aLen - 1][bLen - 1];
    }
}
