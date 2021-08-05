class Solution {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] points = new int[length + 2][length + 2];
        for (int size = 1; size <= length; size ++) {
            boolean alex = size % 2 == 0;
            for (int i = 0; i < length - size + 1; i ++) {
                int j = i + size - 1;
                if (alex) {
                    points[i + 1][j + 1] = Math.max(piles[i] + points[i + 2][j + 1],
                                                    piles[j] + points[i + 1][j]);
                } else {
                    points[i + 1][j + 1] = Math.min(-piles[i] + points[i + 2][j + 1],
                                                    -piles[j] + points[i + 1][j]);
                }
            }
        }
        return points[1][length] > 0;
    }


    // TLE Code..
    // public boolean stoneGame(int[] piles) {
    //     return turn(0, piles.length - 1, true, 0, 0, piles);
    // }
    //
    // boolean turn(int i, int j, boolean alex, int point_a, int point_l, int[] piles) {
    //     if (i == j) { // Lee
    //         point_l += piles[i];
    //         return point_a > point_l;
    //     } else if (piles[i] < piles[j]) {
    //         if (alex) {
    //             point_a += piles[j];
    //         } else {
    //             point_l += piles[j];
    //         }
    //         return turn(i, j - 1, !alex, point_a, point_l, piles);
    //     } else if (piles[i] > piles[j]) {
    //         if (alex) {
    //             point_a += piles[i];
    //         } else {
    //             point_l += piles[i];
    //         }
    //         return turn(i + 1, j, !alex, point_a, point_l, piles);
    //     } else { // piles[i] == piles[j]
    //         if (alex) {
    //             return turn(i + 1, j, !alex, point_a + piles[i], point_l, piles) ||
    //                 turn(i, j - 1, !alex, point_a + piles[j], point_l, piles);
    //         } else {
    //             return turn(i + 1, j, !alex, point_a, point_l + piles[i], piles) &&
    //                 turn(i, j - 1, !alex, point_a, point_l + piles[j], piles);
    //         }
    //     }
    // }
}
