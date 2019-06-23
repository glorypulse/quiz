class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] on_last = new int[nums.length];
        int[] off_last = new int[nums.length];
        on_last[0] = nums[0];
        off_last[0] = 0;

        for (int i = 1; i < nums.length; i ++) {
            on_last[i] = off_last[i - 1] + nums[i];
            off_last[i] = Math.max(on_last[i - 1], off_last[i - 1]);
        }

        return Math.max(on_last[nums.length - 1], off_last[nums.length - 1]);
    }
}
