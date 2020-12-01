class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        int[] sums = new int[length - k + 1]; // subarray length - k
        int[] maxes = new int[length - k + 1];
        for (int i = 0; i < k; i ++) {
            sums[0] += nums[i];
        }
        maxes[0] = sums[0];
        for (int i = k; i < length; i ++) {
            sums[i - k + 1] = sums[i - k] + nums[i];
            maxes[i - k + 1] = sums[i - k + 1];
        }

        for (int i = 1; i <= length - k; i ++) {
            for (int j = k; j <= length - i; j ++) {
                sums[j - k] = sums[j - k + 1] - nums[i - 1];
                maxes[j - k] = Math.max(maxes[j - k], sums[j - k]);
            }
        }

        double maxAvg = -Double.MAX_VALUE;
        for (int i = k; i <= length; i ++) {
            maxAvg = Math.max(maxAvg, (maxes[i - k] + 0.0) / i);
        }
        return maxAvg;
    }
}
