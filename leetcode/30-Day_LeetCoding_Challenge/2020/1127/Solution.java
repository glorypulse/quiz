class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        Boolean[][] sums = new Boolean[sum / 2 + 1][nums.length];
        return check(nums, 0, 0, sum / 2, sums);
    }

    boolean check(int[] nums, int index, int sum, int target, Boolean[][] sums) {
        if (nums.length == index) return false;
        if (sums[sum][index] != null) return sums[sum][index];

        int test = sum + nums[index];
        if (test == target || test < target && check(nums, index + 1, test, target, sums)) {
            sums[sum][index] = true;
        } else {
            sums[sum][index] = check(nums, index + 1, sum, target, sums);
        }

        return sums[sum][index];
    }
}
