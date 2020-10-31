class Solution {
    public int maxDistToClosest(int[] seats) {
        int length = seats.length;
        if (length == 0) return 0;
        int[] distances = new int[length];
        int distance = length - 1;
        for (int i = 0; i < length; i ++) {
            if (seats[i] == 1) {
                distance = 0;
            } else {
                distance ++;
                distances[i] = distance;
            }
        }

        distance = length - 1;
        int max = 0;
        for (int i = length - 1; i >= 0; i --) {
            if (seats[i] == 1) {
                distance = 0;
            } else {
                distance ++;
                distances[i] = Math.min(distances[i], distance);
                max = Math.max(max, distances[i]);
            }
        }
        return max;
    }
}
