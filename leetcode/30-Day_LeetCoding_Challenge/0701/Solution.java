class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1) return n;
        long left = 1;
        long right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid + 1 <= 2 * (long)n / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)(left - 1);
    }
}
