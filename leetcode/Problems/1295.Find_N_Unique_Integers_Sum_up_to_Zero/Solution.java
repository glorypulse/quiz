class Solution {
    public int[] sumZero(int n) {
        int[] ret = new int[n];
        boolean even = n % 2 == 0;
        int max = n / 2;
        int tmp = -max;
        for (int i = 0; i < n; i ++) {
            ret[i] = tmp;
            tmp ++;
            if (even && tmp == 0) tmp ++;
        }
        return ret;
    }
}
