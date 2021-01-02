class Solution {
    public int smallestRangeII(int[] A, int K) {
        int[][][] memo;
        List<int[]> ranges = new ArrayList<>();
        ranges.add(new int[] { A[0] - K, A[0] - K });
        ranges.add(new int[] { A[0] + K, A[0] + K });

        for (int i = 1; i < A.length; i ++) {
            List<int[]> nextRanges = new ArrayList<>();
            int[] current = new int[] { A[i] - K, A[i] + K };
            memo = new int[2][2][];
            for (int[] range: ranges) {
                if (current[0] > range[1]) { // both max
                    range[1] = current[0];
                    if (memo[0][1] != null && memo[0][1][0] > range[0]) continue;
                    memo[0][1] = range;
                } else if (current[1] < range[0]) { // both min
                    range[0] = current[1];
                    if (memo[1][0] != null && memo[1][0][1] < range[1]) continue;
                    memo[1][0] = range;
                } else if (current[0] >= range[0] || current[1] <= range[1]) { // including
                    nextRanges.add(range);
                } else {
                    if (memo[1][1] == null || memo[1][1][0] < range[0]) {
                        memo[1][1] = new int[] { range[0], current[1] };
                    }
                    if (memo[0][0] == null || memo[0][0][1] > range[0]) {
                        memo[0][0] = new int[] { current[0], range[1] };
                    }
                }
            }
            for (int j = 0; j < 2; j ++) {
                for (int l = 0; l < 2; l ++) {
                    if (memo[j][l] != null) {
                        nextRanges.add(memo[j][l]);
                    }
                }
            }
            ranges = nextRanges;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int[] range: ranges) {
            minDiff = Math.min(minDiff, range[1] - range[0]);
        }

        return minDiff;
    }
}
