class Solution {
    public int concatenatedBinary(int n) {
        long decimal = 0;
        for (int num = 1; num <= n; num ++) {
            int tmp = num;
            while (tmp > 0) {
                tmp >>= 1;
                decimal = (decimal << 1) % 1000000007;
            }
            decimal = (decimal + num) % 1000000007;
        }
        return (int)decimal;
    }
}
