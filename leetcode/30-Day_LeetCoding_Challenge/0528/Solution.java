class Solution {
    public int[] countBits(int num) {
        int i = 0;
        int next = Math.min(num, 1);
        int[] ans = new int[num + 1];
        while (i <= next) {
            ans[i] = i;
            i ++;
        }
        if (num <= 1) return ans;

        next *= 2;
        while (i <= num) {
            int j = i;
            while (j < Math.min(next, num + 1)) {
                ans[j] = ans[j - i] + 1;
                j ++;
            }
            i = j;
            next *= 2;
        }
        return ans;
    }
}
