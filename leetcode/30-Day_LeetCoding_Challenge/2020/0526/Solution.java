class Solution {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int[] firstCount = new int[2 * (length + 1)];
        int sum = 0, max = 0;
        Arrays.fill(firstCount, -2);
        firstCount[sum + length] = -1;
        for (int i = 0; i < length; i ++) {
            sum += nums[i] == 1 ? 1 : -1;

            if (firstCount[sum + length] == -2) {
                firstCount[sum + length] = i;
            } else {
                max = Math.max(max, i - firstCount[sum + length]);
            }
        }
        return max;
    }
}
