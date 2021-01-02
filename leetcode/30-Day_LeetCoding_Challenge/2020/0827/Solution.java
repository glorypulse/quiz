class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[][] startIndexes = new int[length][2];
        int[][] endIndexes = new int[length][2];
        for (int i = 0; i < length; i ++) {
            int[] interval = intervals[i];
            startIndexes[i][0] = interval[0];
            endIndexes[i][0] = interval[1];
            startIndexes[i][1] = i;
            endIndexes[i][1] = i;
        }

        Arrays.sort(startIndexes, (a, b) -> a[0] - b[0]);
        Arrays.sort(endIndexes, (a, b) -> a[0] - b[0]);

        int s = 0;
        int[] ans = new int[length];
        for (int i = 0; i < length; i ++) {
            while (s < length && startIndexes[s][0] < endIndexes[i][0]) {
                s ++;
            }
            ans[endIndexes[i][1]] = s < length ? startIndexes[s][1] : -1;
        }

        return ans;
    }
}
