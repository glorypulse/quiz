class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        int count = 0;
        if (k == 0) {
            Set<Integer> zeroSet = new HashSet<>();
            for (int num: nums) {
                if (numSet.contains(num) && !zeroSet.contains(num)) {
                    count ++;
                    zeroSet.add(num);
                }
                numSet.add(num);
            }
        } else {
            for (int num: nums) {
                if (numSet.contains(num)) {
                    continue;
                }
                if (numSet.contains(num - k)) {
                    count ++;
                }
                if (numSet.contains(num + k)) {
                    count ++;
                }
                numSet.add(num);
            }
        }
        return count;
    }
}
