class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int base = 1;
        while (base <= N) {
            base *= 2;
        }
        return base - 1 - N;
    }
}
