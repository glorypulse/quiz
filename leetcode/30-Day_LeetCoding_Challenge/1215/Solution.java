class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;

        int[] ans = new int[length];
        int left = 0;
        int right = length - 1;
        int index = length - 1;
        int leftDouble = nums[left] * nums[left];
        int rightDouble = nums[right] * nums[right];
        while (left <= right) {
            if (leftDouble >= rightDouble) {
                ans[index] = leftDouble;
                left ++;
                if (left > right) break;
                leftDouble = nums[left] * nums[left];
            } else {
                ans[index] = rightDouble;
                right --;
                if (left > right) break;
                rightDouble = nums[right] * nums[right];
            }
            index --;
        }
        return ans;
    }
}
