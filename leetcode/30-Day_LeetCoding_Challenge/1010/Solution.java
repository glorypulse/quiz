class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
                if (a[0] < b[0]) return -1;
                if (a[0] > b[0]) return 1;
                if (a[1] < b[1]) return -1;
                return 1;
            });

        int count = 1;
        int shot = points[0][1];

        for (int i = 1; i < points.length; i ++) {
            int[] point = points[i];
            if (shot >= point[0]) {
                if (shot > point[1]) {
                    shot = point[1];
                    continue;
                }
            } else {
                count ++;
                shot = point[1];
            }
        }

        return count;
    }
}
