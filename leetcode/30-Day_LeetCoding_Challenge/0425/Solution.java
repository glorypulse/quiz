class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int[] parents = new int[length];
        for (int i = 0; i < length; i ++) {
            parents[i] = i;
        }

        int value, max;
        for (int i = 0; i < length; i ++) {
            value = nums[i];
            max = Math.min(i + value, length - 1);
            for (int j = i + 1; j <= max; j ++) {
                parents[j] = parents[i];
            }
            if (parents[length - 1] == 0) return true;
        }
        return false;
    }
}
