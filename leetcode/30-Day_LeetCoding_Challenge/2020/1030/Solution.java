class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] lengthes = new int[length];
        int[] counts = new int[length];
        Arrays.fill(lengthes, 1);
        Arrays.fill(counts, 1);

        int maxLength = 1;
        for (int i = 1; i < length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    if (lengthes[i] < lengthes[j] + 1) {
                        lengthes[i] = lengthes[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengthes[i] == lengthes[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, lengthes[i]);
        }

        int count = 0;
        for (int i = 0; i < length; i ++) {
            if (maxLength == lengthes[i]) {
                count += counts[i];
            }
        }

        return count;
    }
}
