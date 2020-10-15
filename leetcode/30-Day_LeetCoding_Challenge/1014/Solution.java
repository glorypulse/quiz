class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);

        int[] robbedMemo = new int[4];
        // 1st robbed x current robbed, 1st robbed x current not robbed,
        // 1st not robbed x current robbed, 1st not robbed x current unrobbed

        robbedMemo[0] = Integer.MIN_VALUE;
        robbedMemo[1] = nums[0]; // 1st robbed x 2nd not robbed
        robbedMemo[2] = nums[1]; // 1st not robbed x 2nd robbed
        robbedMemo[3] = 0; // 1st not robbed x 2nd not nobbed

        for (int i = 2; i < length; i ++) {
            int[] current = new int[4];
            current[0] = robbedMemo[1] + nums[i];
            current[2] = robbedMemo[3] + nums[i];
            current[1] = Math.max(robbedMemo[0], robbedMemo[1]);
            current[3] = Math.max(robbedMemo[2], robbedMemo[3]);
            robbedMemo = current;
        }

        return Math.max(robbedMemo[1], Math.max(robbedMemo[2],robbedMemo[3]));
    }
}
