class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;
        int index = length - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]) {
                int l = index + 1, r = length - 1;
                while (l <= r) {
                    int nextIndex = (l + r) / 2;
                    if (nums[index] >= nums[nextIndex]) {
                        r = nextIndex - 1;
                    } else if (nextIndex == length - 1 || nums[index] >= nums[nextIndex + 1]) {
                        int tmp = nums[index];
                        nums[index] = nums[nextIndex];
                        nums[nextIndex] = tmp;
                        break;
                    } else {
                        l = nextIndex + 1;
                    }
                }
                break;
            }
            index --;
        }
        int left = index + 1;
        int right = length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }
    }
}
