class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] { -1, -1 };
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right && nums[left] != target) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                right = middle;
            }
        }
        if (left > right) return range;
        range[0] = left;

        left = 0;
        right = length - 1;
        while (nums[right] != target) {
            int middle = (left + right + 1) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }
        range[1] = right;
        return range;
    }
}
