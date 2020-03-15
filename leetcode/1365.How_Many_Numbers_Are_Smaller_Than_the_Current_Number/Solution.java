class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] sortedNums = new int[length];
        for (int i = 0; i < length; i ++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);

        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(sortedNums[0], 0);
        int pre = sortedNums[0];
        for (int i = 1; i < length; i ++) {
            if (pre == sortedNums[i]) continue;
            indexMap.put(sortedNums[i], i);
            pre = sortedNums[i];
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i ++) {
            ans[i] = indexMap.get(nums[i]);
        }

        return ans;
    }
}
