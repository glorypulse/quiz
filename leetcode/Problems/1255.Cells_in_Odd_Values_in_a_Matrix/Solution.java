class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] incArray = new boolean[n + m];

        int rowIndex, colIndex;
        for (int[] index: indices) {
            rowIndex = index[0];
            colIndex = n + index[1];
            incArray[rowIndex] = !incArray[rowIndex];
            incArray[colIndex] = !incArray[colIndex];
        }

        int oddNum = 0;
        for (int i = 0; i < n; i ++) {
            rowIndex = i;
            for (int j = 0; j < m; j ++) {
                colIndex = n + j;
                if (incArray[rowIndex] ^ incArray[colIndex]) {
                    oddNum ++;
                }
            }
        }
        return oddNum;
    }
}
