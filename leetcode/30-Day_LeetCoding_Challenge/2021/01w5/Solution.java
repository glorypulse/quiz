class Solution {
    public int countCornerRectangles(int[][] grid) {
        int length = grid.length;
        if (length <= 1) return 0;
        int count = 0;
        for (int rowIndex = 0; rowIndex < length - 1; rowIndex ++) {
            int[] row = grid[rowIndex];
            for (int i = 0; i < row.length - 1; i ++) {
                if (row[i] == 1) {
                    for (int j = i + 1; j < row.length; j ++) {
                        if (row[j] == 1) {
                            for (int newRowIndex = rowIndex + 1; newRowIndex < length; newRowIndex ++) {
                                if (grid[newRowIndex][i] == 1 && grid[newRowIndex][j] == 1) {
                                    count ++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
