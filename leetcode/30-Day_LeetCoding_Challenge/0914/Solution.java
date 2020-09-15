class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int robbedMax = nums[0];
        int unrobbedMax = 0;

        for (int i = 1; i < length; i ++) {
            int robbedTemp = robbedMax;
            int unrobbedTemp = unrobbedMax;
            robbedMax = unrobbedTemp + nums[i];
            unrobbedMax = Math.max(robbedTemp, unrobbedTemp);
        }
        return Math.max(robbedMax, unrobbedMax);
    }
}