class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<Integer>();
        int n = matrix[0].length;

        int[] row_mins = new int[m];
        ArrayList<ArrayList<Integer>> row_min_cols = new ArrayList<>();
        int[] col_maxs = new int[n];

        Arrays.fill(row_mins, Integer.MAX_VALUE);
        Arrays.fill(col_maxs, Integer.MIN_VALUE);

        int val;
        ArrayList<Integer> cols;
        for (int i = 0; i < m; i ++) {
            cols = new ArrayList<>();
            row_min_cols.add(cols);
            for (int j = 0; j < n; j ++) {
                val = matrix[i][j];
                if (val < row_mins[i]) {
                    row_mins[i] = val;
                    cols = new ArrayList<>();
                    cols.add(j);
                    row_min_cols.set(i, cols);
                } else if (val == row_mins[i]) {
                    cols.add(j);
                }

                if (val > col_maxs[j]) {
                    col_maxs[j] = val;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i ++) {
            val = row_mins[i];
            cols = row_min_cols.get(i);

            for (int col: cols) {
                if (val == col_maxs[col]) {
                    ans.add(val);
                }
            }
        }
        return ans;
    }
}
