class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int length = nums.length; // length >= 1, length <= threshold
        int left = 1;
        int right = nums[length - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int num: nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
