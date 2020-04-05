class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, tmp;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) i ++;
            while (j < nums.length - 1 && nums[j] == 0) j ++;

            if (i < nums.length && i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i ++;
                j ++;
            } else if (i == j) {
                return;
            } else {
                tmp = i;
                i = j;
                j = tmp;
            }
        }
    }
}
