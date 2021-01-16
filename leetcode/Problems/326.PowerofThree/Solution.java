class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            double ans = n / 3.0;
            if ((int) ans != ans) return false;
            n = n / 3;
        }
        return true;
    }
}
