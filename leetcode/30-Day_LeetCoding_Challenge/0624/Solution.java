class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        return numTreesWithMemo(n, memo);
    }

    int numTreesWithMemo(int n, int[] memo) {
        if (memo[n] > 0) return memo[n];
        int count = 0;
        for (int i = 0; i < n; i ++) {
            count += numTreesWithMemo(i, memo) * numTreesWithMemo(n - i - 1, memo);
        }
        memo[n] = count;
        return count;
    }
}
