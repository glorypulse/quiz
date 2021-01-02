class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        if (length == 0) return new ArrayList<Integer>();

        int[] factors = new int[length];
        Arrays.fill(factors, 1);
        int[] childs = new int[length];
        Arrays.fill(childs, -1);
        Arrays.sort(nums);
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < length; i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (nums[i] % nums[j] == 0 && factors[i] < factors[j] + 1) {
                    factors[i] = factors[j] + 1;
                    childs[i] = j;
                }
            }
            if (max < factors[i]) {
                max = factors[i];
                maxIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int index = maxIndex;
        while (index >= 0) {
            ans.add(nums[index]);
            index = childs[index];
        }
        return ans;
    }
}
