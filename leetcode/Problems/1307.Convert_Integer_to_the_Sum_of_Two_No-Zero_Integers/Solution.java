class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];

        int b;
        for (int a = 1; a < n; a ++) {
            if (String.valueOf(a).contains("0")) continue;
            b = n - a;
            if (String.valueOf(b).contains("0")) continue;

            ans[0] = a;
            ans[1] = b;
            break;
        }

        return ans;
    }
}
