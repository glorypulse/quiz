class Solution {
    public int splitArray(int[] nums, int m) {
        return minLargeSum(Integer.MIN_VALUE, 0, m, nums);

    }

    int minLargeSum(int prevMax, int index, int m, int[] nums) {
        if (m == 0) {
            if (index == nums.length) return prevMax;
            return Integer.MAX_VALUE;
        }
        if (index == nums.length) return Integer.MAX_VALUE;
        if (m == 1) {
            int sum = 0;
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
            }
            return Math.max(prevMax, sum);
        }

        int sum = 0;
        int large = Integer.MAX_VALUE;
        for (int i = index; i < nums.length - m + 1; i++) {
            sum += nums[i];
            large = Math.min(large, minLargeSum(Math.max(prevMax, sum), i + 1, m - 1, nums));
        }
        return large;
    }
}
