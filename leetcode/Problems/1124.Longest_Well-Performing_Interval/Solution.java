class Solution {
    public int longestWPI(int[] hours) {
        int[] intervals = new int[hours.length];
        int maxInterval = -1;

        boolean wp = false;
        int i, j;
        for (i = 0; i < hours.length; i ++) {
            wp = hours[i] > 8;
            for (j = i; j > 0; j --) {
                intervals[j] = intervals[j - 1] + (wp ? 1 : -1);
                if (intervals[j] > 0 && j > maxInterval) {
                    maxInterval = j;
                }
            }
            intervals[0] = wp ? 1 : -1;
            if (wp && maxInterval < 0) { maxInterval = 0; }
        }

        return maxInterval + 1;
    }
}
