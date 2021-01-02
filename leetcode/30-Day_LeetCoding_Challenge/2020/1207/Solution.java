class Solution {
    public int[][] generateMatrix(int n) {
        int x = 0;
        int[][] ans = new int[n][n];
        int[][] directions = new int[][] {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 }
        };

        int i = 0, j = 0;
        int d = 0;
        while (x < n * n) {
            x ++;
            ans[i][j] = x;
            int next_i = i + directions[d][0];
            int next_j = j + directions[d][1];
            if (next_i < 0 || next_i >= n || next_j < 0 || next_j >= n ||
                ans[next_i][next_j] > 0) {
                d = (d + 1) % 4;
                next_i = i + directions[d][0];
                next_j = j + directions[d][1];
            }
            i = next_i;
            j = next_j;
        }

        return ans;
    }
}
