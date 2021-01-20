class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int num: nums) {
            if (num < k) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }
        int count = 0;
        for (int key: counts.keySet()) {
            int numCount = counts.get(key);
            if (key >= k - key) {
                if (key == k - key) {
                    count += numCount / 2;
                }
                break;
            } else if (numCount > 0 && counts.get(k - key) != null) {
                count += Math.min(counts.get(k - key), numCount);
            }
        }
        return count;
    }
}
