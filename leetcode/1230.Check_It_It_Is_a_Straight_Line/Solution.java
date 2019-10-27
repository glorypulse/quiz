class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        int[] first = coordinates[0];
        int[] second = coordinates[1];

        int[] coordinate;
        boolean straight = true;

        // x = c
        if (second[0] == first[0]) {
            int c = first[0];

            for (int i = 2; i < coordinates.length; i ++) {
                coordinate = coordinates[i];
                if (coordinate[0] != c) {
                    straight = false;
                    break;
                }
            }
            return straight;
        }

        // y = ax + b
        double a = (second[1] - first[1]) / (second[0] - first[0]);
        double b = first[1] - a * first[0];

        double y;
        for (int i = 2; i < coordinates.length; i ++) {
            coordinate = coordinates[i];
            if (coordinate[1] != a * coordinate[0] + b) {
                straight = false;
                break;
            }
        }

        return straight;
    }
}
