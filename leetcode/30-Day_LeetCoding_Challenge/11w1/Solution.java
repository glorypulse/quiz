class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev = 0;
        for (int[] interval: intervals) {
            if (interval[0] < prev) return false;
            prev = interval[1];
        }

        return true;
    }
}
