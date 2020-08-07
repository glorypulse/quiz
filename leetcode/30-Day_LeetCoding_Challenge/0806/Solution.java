class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        boolean[] existed = new boolean[nums.length];
        List<Integer> duplicates = new ArrayList<>();
        for (int num: nums) {
            if (existed[num - 1]) {
                duplicates.add(num);
            } else {
                existed[num - 1] = true;
            }
        }
        return duplicates;
    }
}
