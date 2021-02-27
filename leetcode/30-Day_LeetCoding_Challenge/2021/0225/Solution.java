class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;

        int maxIndex = -1;
        int minIndex = length - 1;
        int prev = nums[0];
        for (int i = 1; i < length; i ++) {
            int val = nums[i];
            if (prev > val) {
                if (maxIndex < 0) { // first
                    minIndex = i - 1;
                }
                if (nums[minIndex] > val) {
                    while (--minIndex >= 0 && nums[minIndex] > val);
                    nums[++minIndex] = val;
                }
                maxIndex = i;
            } else {
                prev = val;
            }
        }
        if (maxIndex < minIndex) return 0;
        return maxIndex - minIndex + 1;
    }
}
