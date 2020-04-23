class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, count = 0;

        sumMap.put(0, 1);
        for (int num: nums) {
            sum += num;
            count += sumMap.getOrDefault(sum - k, 0);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
