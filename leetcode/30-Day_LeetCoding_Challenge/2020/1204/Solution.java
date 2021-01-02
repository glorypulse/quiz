class Solution {
    public int kthFactor(int n, int k) {
        int i = 1;
        int factor = 1;
        while (k > 0 && i <= n) {
            if (n % i == 0) {
                factor = i;
                k --;
            }
            i ++;
        }
        if (k > 0) return -1;
        return factor;
    }
}
