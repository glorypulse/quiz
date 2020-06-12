class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i ++) {
            counts[nums[i]] ++;
        }
        for (int i = 0; i < counts[0]; i ++) {
            nums[i] = 0;
        }
        for (int i = counts[0]; i < counts[0] + counts[1]; i ++) {
            nums[i] = 1;
        }
        for (int i = counts[0] + counts[1]; i < nums.length; i ++) {
            nums[i] = 2;
        }
    }
}
