class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int i = 0, j = 0;
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        String name;
        int max = 0;
        while (i < row && j < col) {
            name = i + "," + j;
            if (grid[i][j] == 0) {
                j ++;
                if (j == col) {
                    i ++;
                    j = 0;
                }
                continue;
            }

            int border = longest(i, j, grid);
            for (int l = border; l >= 1 && l > max; l --) {
                if (checkSquare(i, j, grid, l)) {
                    max = l;
                    break;
                }
            }

            j ++;
            if (j == col) {
                i ++;
                j = 0;
            }
        }

        return max * max;
    }

    int longest(int i, int j, int[][] grid) {
        int count = 0;
        int length = grid[i].length;
        while (j < length && grid[i][j] != 0) {
            count ++;
            j ++;
        }
        return count;
    }

    boolean checkSquare(int n, int m, int[][] grid, int border) {
        int i, j;
        int row = grid.length;

        // 左上 => 右上はチェック済み
        // 右上 => 右下
        for (i = n, j = m + border - 1; i < n + border; i ++) {
            if (i >= row) return false;
            if (grid[i][j] == 0) return false;
        }

        // 右下 => 左下
        for (i = n + border - 1, j = m + border - 1; j >= m; j --) {
            if (grid[i][j] == 0) return false;
        }

        // 左下 => 左上
        for (i = n + border - 1, j = m; i >= n; i --) {
            if (grid[i][j] == 0) return false;
        }

        return true;
    }
}
