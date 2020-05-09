class Solution {
    public boolean isPerfectSquare(int num) {
        long tmp = 1;
        while (tmp * tmp < num) {
            tmp <<= 1;
        }
        long left = tmp >> 1;
        long right = tmp;


        while (left <= right) {
            long mid = (left + right) / 2;
            long midSquare = mid * mid;
            if (midSquare == num) return true;
            if (midSquare > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
