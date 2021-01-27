class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        for (int num: nums) {
            if (num == 0) {
                count --;
            } else if (count <= 0) {
                count = k;
            } else {
                return false;
            }
        }
        return true;
    }
}
