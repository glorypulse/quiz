class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        LinkedList<Integer> prev = new LinkedList<>();
        addSubsets(0, nums, prev, set);
        return new ArrayList<>(set);
    }

    void addSubsets(int index, int[] nums, LinkedList<Integer> prev, Set<List<Integer>> set) {
        if (index == nums.length) {
            set.add(new ArrayList<>(prev));
            return;
        }
        prev.add(nums[index]);
        addSubsets(index + 1, nums, prev, set);
        prev.removeLast();
        addSubsets(index + 1, nums, prev, set);
    }
}
