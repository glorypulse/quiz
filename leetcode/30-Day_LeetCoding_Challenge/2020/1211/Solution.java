class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) return length;
        int num = nums[0];
        boolean twice = false;
        int newLength = 1;
        for (int i = 1; i < length; i ++) {
            if (nums[i] < num || nums[i] == num && twice) {
                if (!replaceDuplicates(num, i, nums)) {
                    break;
                }
                num = nums[i];
                twice = false;
            } else if (nums[i] == num) {
                twice = true;
            } else {
                num = nums[i];
                twice = false;
            }
            newLength ++;
        }
        return newLength;
    }

    boolean replaceDuplicates(int num, int index, int[] nums) {
        int i = index, j = index;
        while (j < nums.length && nums[j] <= num) {
            j ++;
        }
        if (j == nums.length) return false;

        while (i < nums.length && j < nums.length && nums[i] <= num) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j ++;
        }

        return true;
    }
}
