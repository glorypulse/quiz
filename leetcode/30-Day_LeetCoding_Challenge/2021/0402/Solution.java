class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[m + 1][n + 1];
        int max = 0;
        for (String str: strs) {
            int oneCount = 0;
            for (char c: str.toCharArray()) {
                oneCount += c - '0';
            }
            int zeroCount = str.length() - oneCount;
            for (int i = m; i >= zeroCount; i --) {
                for (int j = n; j >= oneCount; j --) {
                    counts[i][j] = Math.max(counts[i][j], counts[i - zeroCount][j - oneCount] + 1);
                    max = Math.max(max, counts[i][j]);
                }
            }
        }
        return max;
    }
}
