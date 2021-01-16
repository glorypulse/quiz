class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid, value;

        while (left < right) {
            mid = (left + right) / 2;
            value = nums[mid];
            if (value == target) return mid;

            if (target > value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        value = nums[left];
        if (target > value) return left + 1;
        return left;
    }
}
