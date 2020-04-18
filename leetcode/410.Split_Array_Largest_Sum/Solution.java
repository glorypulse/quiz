class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            sum += num;
            max = Math.max(max, num);
        }

        long high = sum;
        long low = max;
        long mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (isPossible(nums, m, mid)) {
                if (high == mid) return (int)mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int)mid;
    }

    boolean isPossible(int[] nums, int m, long max) {
        int k = 1;
        long sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (sum > max) {
                if (++k > m) return false;
                sum = nums[i];
            }
        }
        return true;
    }
}
