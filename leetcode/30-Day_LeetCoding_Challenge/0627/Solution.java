class Solution {
    public int numSquares(int n) {
        if (n <= 1) return n;

        int[] numSqu = new int[n + 1];
        Arrays.fill(numSqu, -1);
        numSqu[1] = 1;
        numSqu[0] = 0;
        return getNumSquares(numSqu, n);
    }

    int getNumSquares(int[] numSqu, int index) {
        if (numSqu[index] >= 0) return numSqu[index];

        int min = Integer.MAX_VALUE;
        for (long i = Math.min(index / 2, (1 << 16) - 1); i > 0; i --) {
            long val = i * i;
            if (index < val) continue;
            min = Math.min(min, getNumSquares(numSqu, (int)(index - val)) + 1);
        }
        numSqu[index] = min;
        return numSqu[index];
    }
}
