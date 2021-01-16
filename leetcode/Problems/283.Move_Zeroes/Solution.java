class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, tmp;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0 && i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            if (nums[i] != 0) i ++;
            if (nums[j] == 0) j ++;
        }
    }
}
