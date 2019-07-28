class Solution {
    public int tribonacci(int n) {
        int[] memo = new int[n + 1];
        return calcTribonacci(n, memo);
    }

    int calcTribonacci(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = calcTribonacci(n - 3, memo) + calcTribonacci(n - 2, memo) + calcTribonacci (n - 1, memo);
        return memo[n];
    }
}
