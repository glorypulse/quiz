class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return minLargeSum(0, m, nums, sum);

    }

    int minLargeSum(int index, int m, int[] nums, int sum) {
        if (m == 1) {
            return sum;
        }
        if (m == 2) {
            int min = Integer.MAX_VALUE;
            int tmpSum = 0;
            for (int i = index; i < nums.length - 1; i ++) {
                tmpSum += nums[i];
                min = Math.min(min, Math.max(tmpSum, sum - tmpSum));
            }
            return min;
        }
        int min = Integer.MAX_VALUE;
        int tmpSum = 0;
        for (int i = index; i < nums.length - m + 1; i ++) {
            tmpSum += nums[i];
            min = Math.min(min, Math.max(tmpSum, minLargeSum(index + 1, m - 1, nums, sum - tmpSum)));
        }
        return min;
    }
}
