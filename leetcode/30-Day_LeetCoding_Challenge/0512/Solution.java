class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            } else if (mid > 0 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else {
                if (mid % 2 == 0) {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }
}
