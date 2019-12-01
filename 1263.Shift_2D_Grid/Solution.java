import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        List<List<Integer>> shiftedGridList = new ArrayList<>();
        if (n == 0) return shiftedGridList;
        int m = grid[0].length;
        int[][] shiftedGrid = new int[n][m];

        int new_i, new_j;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                new_i = (i +  (j + k) / m) % n;
                new_j = (j + (k % m)) % m;
                shiftedGrid[new_i][new_j] = grid[i][j];
            }
        }

        for (int i = 0; i < n; i ++) {
            List<Integer> shiftedRow = new ArrayList<>();
            shiftedGridList.add(shiftedRow);
            for (int j = 0; j < m; j ++) {
                shiftedRow.add(shiftedGrid[i][j]);
            }
        }

        return shiftedGridList;
    }
}
