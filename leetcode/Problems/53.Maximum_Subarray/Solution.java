class Solution {
    public int maxSubArray(int[] nums) {
        int min = 0, count = 0, ret = Integer.MIN_VALUE;

        for (int num: nums) {
            count += num;
            if (ret < count - min) {
                ret = count - min;
            }
            if (count < min) min = count;
        }

        return ret;
    }
}
