class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        boolean diagonal = true;
        int[] diagonalOrder = new int[m * n];
        int index = 0;
        while (index < m * n) {
            diagonalOrder[index] = matrix[i][j];
            if (diagonal) {
                int next_i = i - 1;
                int next_j = j + 1;
                if (next_j == n) {
                    i = i + 1;
                    diagonal = false;
                } else if (next_i < 0) {
                    j = j + 1;
                    diagonal = false;
                } else {
                    i = next_i;
                    j = next_j;
                }
            } else {
                int next_i = i + 1;
                int next_j = j - 1;
                if (next_i == m) {
                    j = j + 1;
                    diagonal = true;
                } else if (next_j < 0) {
                    i = i + 1;
                    diagonal = true;
                } else {
                    i = next_i;
                    j = next_j;
                }
            }
            index ++;
        }
        return diagonalOrder;
    }
}
