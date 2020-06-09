class Solution {
    public boolean isPowerOfTwo(int n) {
        long test = 1;
        while (test < n) {
            test = test << 1;
        }
        if (test == n) {
            return true;
        }
        return false;
    }
}
