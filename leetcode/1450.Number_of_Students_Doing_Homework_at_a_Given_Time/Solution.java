class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int length = startTime.length;
        for (int i = 0; i < length; i ++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count ++;
            }
        }

        return count;
    }
}
