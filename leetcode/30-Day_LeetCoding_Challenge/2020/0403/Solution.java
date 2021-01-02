class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = 0;

        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
            if (max < sum - min) {
                max = sum - min;
            }
            if (min > sum) {
                min = sum;
            }
        }

        return max;
    }
}
