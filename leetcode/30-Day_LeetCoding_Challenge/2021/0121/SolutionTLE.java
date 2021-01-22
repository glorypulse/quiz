class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) return nums;
        ArrayList<Integer> subsequence = new ArrayList<>();
        for (int i = 0; i < k; i ++) {
            subsequence.add(nums[i]);
        }

        for (int i = k; i < length; i ++) {
            subsequence.add(nums[i]);
            int j = 0;
            while (j < k) {
                if (subsequence.get(j) > subsequence.get(j + 1)) {
                    subsequence.remove(j);
                    break;
                }
                j ++;
            }
            if (j == k) {
                subsequence.remove(j);
            }
        }

        int[] mostCompetitiveSubsequence = new int[k];
        for (int i = 0; i < k; i ++) {
            mostCompetitiveSubsequence[i] = subsequence.get(i);
        }
        return mostCompetitiveSubsequence;
    }
}
