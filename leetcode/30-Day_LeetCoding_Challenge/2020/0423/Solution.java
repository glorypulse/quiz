class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        long result = m;
        long i = m;
        long plus = 1;
        while (i <= n) {
            result &= i;
            if (result == 0) return 0;
            while ((result & plus) == 0) plus *= 2;
            i = result + plus;

        }
        return (int)result;
    }
}
