class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int i = 0;
        int j = 0;
        int length1 = slots1.length;
        int length2 = slots2.length;
        List<Integer> availableDuration = new ArrayList<>();
        Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));
        while (i < length1 && j < length2) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (start < end && end - start >= duration) {
                availableDuration.add(start);
                availableDuration.add(start + duration);
                break;
            }
            if (end == slots1[i][1]) {
                i ++;
            } else {
                j ++;
            }
        }
        return availableDuration;
    }
}
