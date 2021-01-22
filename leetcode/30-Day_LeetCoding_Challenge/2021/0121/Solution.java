class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) return nums;
        int[][] numsWithIndex = new int[length][];
        for (int i = 0; i < length; i ++) {
            numsWithIndex[i] = new int[] { nums[i], i };
        }
        Arrays.sort(numsWithIndex, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
            );
        int[][] subsequenceWithIndex = new int[k][];
        int index = -1;
        int j = 0;
        for (int i = 0; i < k; i ++) {
            if (subsequenceWithIndex[i] != null) {
                index = subsequenceWithIndex[i][1];
                continue;
            }
            while (j < length) {
                int nextIndex = numsWithIndex[j][1];
                if (index < nextIndex) {
                    if (nextIndex <= length - k + i) {
                        subsequenceWithIndex[i] = numsWithIndex[j];
                        index = nextIndex;
                        break;
                    } else {
                        subsequenceWithIndex[nextIndex - length + k] = numsWithIndex[j];
                    }
                }
                j ++;
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i ++) {
            ans[i] = subsequenceWithIndex[i][0];
        }
        return ans;
    }
}
