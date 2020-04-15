class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumMemo = new HashMap<>();
        int sum = 0, max = 0;
        sumMemo.put(sum, -1);
        Integer memoIndex;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i] == 1 ? 1 : -1;
            memoIndex = sumMemo.get(sum);
            if (memoIndex == null) {
                sumMemo.put(sum, i);
            } else {
                if (max < i - memoIndex) {
                    max = i - memoIndex;
                }
            }
        }
        return max;
    }
}
