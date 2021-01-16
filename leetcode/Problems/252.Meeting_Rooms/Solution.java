class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // 配列を並べ変える
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // ei < si+1をチェックする
        for (int i = 0; i < intervals.length - 1; i ++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
