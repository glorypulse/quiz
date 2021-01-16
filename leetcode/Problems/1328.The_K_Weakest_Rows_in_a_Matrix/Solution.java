class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] soldierRows = new int[mat.length][2];
        int solCount = 0;
        int[] row;
        for (int i = 0; i < mat.length; i ++) {
            row = mat[i];
            for (solCount = 0; solCount < row.length; solCount ++) {
                if (row[solCount] == 0) break;
            }
            soldierRows[i][0] = solCount;
            soldierRows[i][1] = i;
        }

        Arrays.sort(soldierRows, (row1, row2) -> {
                if (row1[0] < row2[0] || (row1[0] == row2[0] && row1[1] < row2[1])) {
                    return -1;
                } else {
                    return 1;
                }
            });

        int[] kWeakRows = new int[k];
        for (int i = 0; i < k; i ++) {
            kWeakRows[i] = soldierRows[i][1];
        }
        return kWeakRows;
    }
}
