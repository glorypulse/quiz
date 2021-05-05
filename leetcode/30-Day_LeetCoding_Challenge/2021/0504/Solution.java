class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean dec = false;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i - 1] > nums[i]) {
                if (!dec) {
                    dec = true;
                    if (i == 1 || nums[i - 2] <= nums[i]) continue;
                    nums[i] = nums[i - 1];
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
