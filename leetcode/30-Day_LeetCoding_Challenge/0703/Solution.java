class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) return cells;

        int n = N % 14;
        if (n == 0) {
            n = 14;
        }
        int[] nextCells = new int[8];
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < 7; j ++) {
                nextCells[j] = cells[j - 1] ^ cells[j + 1] ^ 1;
            }
            int[] tmp = cells;
            cells = nextCells;
            nextCells = tmp;
            nextCells[0] = 0;
            nextCells[7] = 0;
        }
        return cells;
    }
}
