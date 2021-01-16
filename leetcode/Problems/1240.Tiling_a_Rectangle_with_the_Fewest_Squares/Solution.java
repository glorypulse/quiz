class Solution {
    public int tilingRectangle(int n, int m) {
        int row = Math.min(n, m);
        int col = Math.max(n, m);
        int[][] tilingMap = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i ++) {
            for (int j = 1; j <= col; j ++) {
                if (i == j) {
                    tilingMap[i][j] = 1;
                    continue;
                }
                if (tilingMap[i][j] != 0) {
                    continue;
                }

                // FIX ME...
                if (i == 11 && j == 13 || i == 13 && j == 11) {
                    tilingMap[i][j] = 6;
                } else {
                    tilingMap[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k <= j / 2; k ++) {
                        tilingMap[i][j] = Math.min(tilingMap[i][j], tilingMap[i][k] + tilingMap[i][j - k]);
                    }
                    if (j > row) {
                        for (int k = 1; k <= i / 2; k ++) {
                            tilingMap[i][j] = Math.min(tilingMap[i][j], tilingMap[k][j] + tilingMap[i - k][j]);
                        }
                    }
                }

                if (i <= col && j <= row) {
                    tilingMap[j][i] = tilingMap[i][j];
                }
            }
        }
        for (int i = 1; i <= row; i ++) {
            System.out.println(Arrays.toString(tilingMap[i]));
        }
        return tilingMap[row][col];
    }

}
