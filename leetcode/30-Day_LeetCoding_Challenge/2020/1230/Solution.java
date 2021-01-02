class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 1) {
                    setOne(ans, i - 1, j - 1);
                    setOne(ans, i - 1, j);
                    setOne(ans, i - 1, j + 1);

                    setOne(ans, i, j - 1);
                    setOne(ans, i, j + 1);

                    setOne(ans, i + 1, j - 1);
                    setOne(ans, i + 1, j);
                    setOne(ans, i + 1, j + 1);
                }
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (ans[i][j] < 2 || ans[i][j] > 3) {
                    board[i][j] = 0;
                } else if (ans[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    void setOne(int[][] ans, int i, int j) {
        if (i >= 0 && j >= 0 && i < ans.length && j < ans[0].length) {
            ans[i][j] += 1;
        }
    }
}
