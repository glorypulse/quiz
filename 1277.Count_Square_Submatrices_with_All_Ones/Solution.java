class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int count = 0;

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                if (matrix[i][j] == 1) {
                    count += getSquareSize(matrix, i, j);
                }
            }
        }

        return count;
    }

    int getSquareSize(int[][] matrix, int i, int j) {
        int size = 1;
        while(i + size < matrix.length && j + size < matrix[i].length && matrix[i][j + size] == 1 && matrix[i + size][j] == 1) size ++;
        for (int s = 1; s < size; s ++) {
            int t = 1;
            while(t < size && matrix[i + s][j + t] == 1) t ++;
            size = Math.max(s, t);
        }
        return size;
    }
}
