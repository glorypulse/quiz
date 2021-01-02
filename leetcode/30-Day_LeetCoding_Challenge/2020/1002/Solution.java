class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        LinkedList<Integer> sumList = new LinkedList<>();
        findSumList(candidates, 0, target, 0, sumList, ansList);
        return ansList;
    }

    void findSumList(int[] nums, int index, int target, int sum, LinkedList<Integer> sumList, List<List<Integer>> ansList) {
        for (int i = index; i < nums.length; i ++) {
            int num = nums[i];
            if (target < sum + num) continue;
            sum += num;
            sumList.add(num);
            if (target == sum) {
                ansList.add(new ArrayList<>(sumList));
            } else {
                findSumList(nums, i, target, sum, sumList, ansList);
            }
            sum -= num;
            sumList.removeLast();
        }
    }
}
