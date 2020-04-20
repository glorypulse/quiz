class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        int lv, rv, mv;
        while (left <= right) {
            mid = (left + right) / 2;
            lv = nums[left];
            if (lv == target) return left;
            rv = nums[right];
            if (rv == target) return right;
            mv = nums[mid];
            if (mv == target) return mid;

            if (lv < mv) { // the peak is right-side.
                if (target < lv && target < mv ||
                    target > lv && target > mv) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // the peak is left-side.
                if (target < lv && target < mv ||
                    target > lv && target > mv) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
