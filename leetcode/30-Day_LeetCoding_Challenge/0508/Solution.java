class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length <= 2) return true;
        double x0 = coordinates[0][0];
        if (coordinates[1][0] != x0) {
            double y0 = coordinates[0][1];
            double delta = (coordinates[1][1] - y0) / (coordinates[1][0] - x0);
            for (int i = 2; i < length; i ++) {
                if (coordinates[i][0] == x0 || delta != (coordinates[i][1] - y0) / (coordinates[i][0] - x0)) {
                    return false;
                }
            }
        } else {
            for (int i = 2; i < length; i ++) {
                if (coordinates[i][0] != x0) {
                    return false;
                }
            }
        }

        return true;
    }
}
