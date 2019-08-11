class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] sumArray = int[m + 1][nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            sumArray[0][i] = sum;
        }

        for (int j = 1; j < m; j ++) {
            for (int i = j; i < nums.length; i ++) {
                sum = 0;
                for (int l = j; l < i; l ++) { // ??
                    sum += nums[l];
                }
                Math.max(sumArray[j - 1][i - 1], sum);
            }
        }

        return minLargeSum(Integer.MIN_VALUE, 0, m, nums);

    }
}
