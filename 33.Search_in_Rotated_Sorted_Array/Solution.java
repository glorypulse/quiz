class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == nums.length - 1) break;
            if (nums[mid] > nums[mid + 1]) break;
            if (nums[left] < nums[right]) {
                mid = right;
                break;
            }
            if (nums[left] <= nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int pivot = mid;
        if (target < nums[0]) {
            left = pivot + 1;
            right = nums.length - 1;
        } else {
            left = 0;
            right = pivot;
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
