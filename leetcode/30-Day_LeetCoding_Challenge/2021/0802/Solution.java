class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, ArrayList<Integer>> numsMap = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            int val = nums[i];
            numsMap.putIfAbsent(val, new ArrayList<>());
            numsMap.get(val).add(i);
        }

        int[] ans = new int[] { -1, -1 };
        for (int i = 0; i < length; i ++) {
            int key = target - nums[i];
            if (numsMap.containsKey(key)) {
                ArrayList<Integer> indexList = numsMap.get(key);
                for (int index: indexList) {
                    if (index != i) {
                        ans[0] = i;
                        ans[1] = index;
                        break;
                    }
                }
                if (ans[0] == i) break;
            }
        }
        return ans;
    }
}
