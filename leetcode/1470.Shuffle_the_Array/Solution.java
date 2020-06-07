class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffledNums = new int[nums.length];
        int i = 0, j = 0;
        boolean next = false;
        while (j < 2 * n) {
            shuffledNums[j] = nums[i];
            j ++;
            if (next) {
                i = i - n + 1;
            } else {
                i += n;
            }
            next = !next;
        }
        return shuffledNums;
    }
}
