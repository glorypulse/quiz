class Solution {
    public int mirrorReflection(int p, int q) {
        if (q == 0) return 0;
        if (q % 2 == 1) {
            return p % 2 == 0 ? 2 : 1;
        } else if (p % 2 == 1) {
            return 0;
        }
        return mirrorReflection(p / 2, q / 2);
    }
}
