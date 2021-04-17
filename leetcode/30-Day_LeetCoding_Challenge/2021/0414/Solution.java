class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        Integer[] memo = new Integer[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        return getFib(n, memo);
    }

    int getFib(int n, Integer[] memo) {
        if (memo[n] != null) return memo[n];
        memo[n] = getFib(n - 1, memo) + getFib(n - 2, memo);
        return memo[n];
    }
}
