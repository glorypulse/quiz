class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i ++) {
            flow(0, i, 0, matrix, pacific);
            flow(0, i, n - 1, matrix, atlantic);
        }
        for (int i = 0; i < n; i ++) {
            flow(0, 0, i, matrix, pacific);
            flow(0, m - 1, i, matrix, atlantic);
        }

        List<List<Integer>> flowList = new ArrayList<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> flowXY = new ArrayList<>();
                    flowXY.add(i);
                    flowXY.add(j);
                    flowList.add(flowXY);
                }
            }
        }
        return flowList;
    }

    void flow(int toValue, int i, int j, int[][] matrix, boolean[][] ocean) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length ||
            ocean[i][j] || matrix[i][j] < toValue) {
            return;
        }

        ocean[i][j] = true;
        flow(matrix[i][j], i + 1, j, matrix, ocean);
        flow(matrix[i][j], i - 1, j, matrix, ocean);
        flow(matrix[i][j], i, j + 1, matrix, ocean);
        flow(matrix[i][j], i, j - 1, matrix, ocean);
    }
}
