class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) return;
        int[] tmp  = new int[length];
        for (int i = 0; i < k; i ++) {
            tmp[i] = nums[length - k + i];
        }
        for (int i = k; i < length; i ++) {
            tmp[i] = nums[i - k];
        }
        for (int i = 0; i < length; i ++) {
            nums[i] = tmp[i];
        }
        // for (int i = 0; i < length - 1 - (length - 1) % k; i ++) {
        //     int rotateIndex = ((i % k) + length - k) % length;
        //     int tmp = nums[i];
        //     nums[i] = nums[rotateIndex];
        //     nums[rotateIndex] = tmp;
        // }
    }
}
