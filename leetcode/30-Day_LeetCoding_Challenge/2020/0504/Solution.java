class Solution {
    public int findComplement(int num) {
        int d = 1;
        int check = 1;
        while (d < Integer.MAX_VALUE) {
            int ans = num - check;
            if (ans <= 0) {
                return -ans;
            }
            d *= 2;
            check += d;
        }
        return 0;
    }
}
