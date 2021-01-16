class Solution {
    public int getMaximumGenerated(int n) {
        if (n <= 1) return n;
        int[] generated = new int[n + 1];
        Arrays.fill(generated, -1);
        generated[0] = 0;
        generated[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i ++) {
            if (i % 2 == 0) {
                generated[i] = generated[i / 2];
            } else {
                generated[i] = generated[(i - 1) / 2] + generated[(i - 1) / 2 + 1];
            }
            max = Math.max(max, generated[i]);
        }
        return max;
    }
}
