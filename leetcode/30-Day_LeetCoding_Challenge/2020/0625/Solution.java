class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            int val = nums[i];
            for (int j = i + 1; j < nums.length; j ++) {
                if (val == nums[j]) return val;
            }
        }
        return -1;
    }
}
