class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            int count = countMap.getOrDefault(num, 0);
            count ++;
            countMap.put(num, count);
        }

        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
