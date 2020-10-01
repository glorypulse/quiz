class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) return 1;
        for (int i = 0; i < length; i ++) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] > length || nums[nums[i] - 1] == nums[i]) {
                    nums[i] = 0;
                    break;
                }

                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        int ans = length + 1;
        for (int i = 0; i < length; i ++) {
            if (nums[i] != i + 1) {
                ans = i + 1;
                break;
            }
        }

        return ans;
    }
}
