class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < m; i ++) {
            setRegion(board, visited, 0, i);
            setRegion(board, visited, n - 1, i);
        }
        for (int i = 1; i < n - 1; i ++) {
            setRegion(board, visited, i, 0);
            setRegion(board, visited, i, m - 1);
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void setRegion(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return;
        visited[i][j] = true;
        if (board[i][j] == 'X') return;
        setRegion(board, visited, i + 1, j);
        setRegion(board, visited, i - 1, j);
        setRegion(board, visited, i, j + 1);
        setRegion(board, visited, i, j - 1);
    }
}
