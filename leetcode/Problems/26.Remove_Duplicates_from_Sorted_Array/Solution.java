class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) return length;
        int i = 0, j = 1;
        while (j < length) {
            int value = nums[i];
            i ++;

            while (j < length && value >= nums[j]) j ++;
            if (j >= length) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        return i;
    }
}
