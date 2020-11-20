class Solution {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) return new int[0][];
        Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            });
        int[] interval = intervals[0];
        List<int[]> mergedIntervalsList = new ArrayList<>();
        for (int i = 1; i < length; i ++) {
            if (interval[1] >= intervals[i][1]) continue;
            if (interval[1] < intervals[i][0]) {
                mergedIntervalsList.add(interval);
                interval = intervals[i];
            } else {
                interval[1] = intervals[i][1];
            }
        }
        mergedIntervalsList.add(interval);

        int[][] mergedIntervals = new int[mergedIntervalsList.size()][2];
        int i = 0;
        for (int[] iv: mergedIntervalsList) {
            mergedIntervals[i] = iv;
            i ++;
        }
        return mergedIntervals;
    }
}
