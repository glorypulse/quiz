class Solution {
    public int maximalSquare(char[][] matrix) {
        int row_length = matrix.length;
        if (row_length == 0) return 0;
        int col_length = matrix[0].length;
        int max = 0;

        for (int i = 0; i < row_length; i ++) {
            for (int j = 0; j < col_length; j ++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, checkSquare(i, j, matrix));
                }
            }
        }
        return max * max;
    }

    int checkSquare(int i, int j, char[][] matrix) {
        int row_length = matrix.length;
        int col_length = matrix[i].length;

        int size = 0;
        for (int t = j; t < col_length; t ++) {
            if (matrix[i][t] == '0') break;
            size ++;
        }
        size = Math.min(row_length - i, size);

        for (int s = i + 1; s < i + size; s ++) {
            for (int t = j; t < j + size; t ++) {
                if (matrix[s][t] == '0') {
                    size = Math.max(s - i, t - j);
                    break;
                }
            }
        }

        return size;
    }
}
