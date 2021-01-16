class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] countArray = new int[nums.length];

        int oddCount = 0;
        int count = 0;
        for (int num: nums) {
            countArray[oddCount] ++;
            if (num % 2 != 0) {
                oddCount ++;
            }
            if (oddCount - k >= 0) {
                count += countArray[oddCount - k];
            }
        }

        return count;
    }
}
