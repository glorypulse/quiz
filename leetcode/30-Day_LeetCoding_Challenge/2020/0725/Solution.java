class Solution {
    public int findMin(int[] nums) {
        return getMinWithRange(nums, 0, nums.length - 1);
    }

    int getMinWithRange(int[] nums, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return Math.min(getMinWithRange(nums, left, mid),
                                getMinWithRange(nums, mid + 1, right));
            }
            if (nums[left] <= nums[mid] && nums[left] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
