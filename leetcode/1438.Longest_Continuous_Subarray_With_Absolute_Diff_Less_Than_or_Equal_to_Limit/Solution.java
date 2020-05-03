class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i ++) {
            if (length - i <= max) break;

            int test = i;
            Set<Integer> okSet = new HashSet<>();
            boolean valid = true;
            while (valid && test < length) {
                if (!okSet.contains(nums[test])) {
                    for (int j = i; j < test; j ++) {
                        if (Math.abs(nums[test] - nums[j]) > limit) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid) {
                    max = Math.max(max, test - i + 1);
                    okSet.add(nums[test]);
                    test ++;
                }
            }
        }
        return max;
    }
}
