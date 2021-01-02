class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        // 1 <= n <= 200
        int m = board[0].length;

        // 1 <= word.length <= 10^3
        char c = word.charAt(0);
        boolean[][] visiting = new boolean[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (board[i][j] == c) {
                    if (check(board, i, j, word, 0, visiting)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean check(char[][] board, int i, int j, String word, int index, boolean[][] visiting) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visiting[i][j]) {
            return false;
        }

        visiting[i][j] = true;
        boolean ans = false;
        if (board[i][j] == word.charAt(index)) {
            if (index == word.length() - 1) {
                ans = true;
            } else {
                index ++;
                ans = check(board, i + 1, j, word, index, visiting) ||
                    check(board, i - 1, j, word, index, visiting) ||
                    check(board, i, j + 1, word, index, visiting) ||
                    check(board, i, j - 1, word, index, visiting);
            }
        }
        if (ans) {
            return true;
        }
        visiting[i][j] = false;
        return false;
    }
}
