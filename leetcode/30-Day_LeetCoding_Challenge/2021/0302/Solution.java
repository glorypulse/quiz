class Solution {
    public int[] findErrorNums(int[] nums) {
        int count = 1;
        int[] errors = new int[] { -1, nums.length };
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] < count) {
                errors[0] = nums[i];
                count = nums[i];
            } else if (nums[i] > count) {
                errors[1] = count;
                count = nums[i];
            }
            count ++;
        }
        return errors;
    }
}
