class Solution {
    public int divide(int dividend, int divisor) {
        boolean minus = false;
        int count = 0;
        if (dividend == divisor) return 1;
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor < 0) {
            divisor = -divisor;
            minus = !minus;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (minus && divisor == 1) return Integer.MAX_VALUE;
            count ++;
            dividend = -(dividend + divisor);
            minus = !minus;
        } else if (dividend < 0) {
            dividend = -dividend;
            minus = !minus;
        }

        int countNum = 1;
        long cur = divisor;
        while (cur << 1 < Integer.MAX_VALUE && dividend > cur << 1) {
            countNum <<= 1;
            cur <<= 1;
        }
        while (dividend >= divisor) {
            if (dividend >= cur) {
                count += countNum;
                dividend -= cur;
            }
            countNum >>= 1;
            cur >>= 1;
        }

        if (minus) return -count;
        return count;
    }
}
