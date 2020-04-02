class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            if (numSet.contains(num)) {
                numSet.remove(num);
            } else {
                numSet.add(num);
            }
        }
        int ans = 0;
        for (int num: numSet) {
            ans = num;
        }
        return ans;
    }
}
