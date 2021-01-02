class Solution {
    int[] weightSums;
    int totalSum;
    Random random;

    public Solution(int[] w) {
        weightSums = new int[w.length];
        totalSum = 0;
        for (int i = 0; i < w.length; i ++) {
            totalSum += w[i];
            weightSums[i] = totalSum - 1;
        }
        random = new Random();
    }

    public int pickIndex() {
        int r = random.nextInt(totalSum);

        int left = 0, right = weightSums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (weightSums[mid] == r) {
                return mid;
            } else if (weightSums[mid] < r) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0 || r > weightSums[right]) return right + 1;
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
