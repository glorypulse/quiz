class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,
                    (a, b) -> {
                        if (a[1] < b[1]) return 1;
                        if (a[1] > b[1]) return -1;
                        if (a[0] > b[0]) return 1;
                        return -1;
                    });

        int start = Integer.MAX_VALUE;
        int count = intervals.length;
        for (int[] interval: intervals) {
            if (interval[0] >= start) {
                count --;
            } else {
                start = interval[0];
            }
        }
        return count;
    }
}
