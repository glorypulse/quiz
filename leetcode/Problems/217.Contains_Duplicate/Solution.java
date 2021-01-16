class Solution {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length <= 1) return false;
        Arrays.sort(nums);
        for (int i = 1; i < length; i ++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}
