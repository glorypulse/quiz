class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 左上, 右上, 左下, 右下, 上, 右, 下, 左
        int[][] blackQueens = new int[8][];
        boolean[] existedBlackQueens = new boolean[8];
        int delta_x, delta_y, tmp;
        int index;

        for (int[] queen: queens) {
            delta_x = queen[0] - king[0];
            delta_y = queen[1] - king[1];

            if (delta_x == 0) {
                if (delta_y > 0) { // 上
                    index = 4;
                } else { // 下
                    index = 6;
                }
                if (existedBlackQueens[index]) {
                    tmp = blackQueens[index][1] - king[1]; // y
                    if (Math.abs(delta_y) < Math.abs(tmp)) {
                        blackQueens[index] = queen;
                    }
                } else {
                    existedBlackQueens[index] = true;
                    blackQueens[index] = queen;
                }
            } else { // 左または右
                if (delta_x < 0) {
                    if (delta_y == delta_x) { // 左上
                        index = 0;
                    } else if (delta_y == 0) { // 左
                        index = 7;
                    } else if (delta_y == -delta_x) { // 左下
                        index = 2;
                    } else {
                        continue;
                    }
                } else {
                    if (delta_y == delta_x) { // 右下
                        index = 3;
                    } else if (delta_y == 0) { // 右
                        index = 5;
                    } else if (delta_y == -delta_x) { // 右上
                        index = 1;
                    } else {
                        continue;
                    }
                }
                if (existedBlackQueens[index]) {
                    tmp = blackQueens[index][0] - king[0]; // x
                    if (Math.abs(delta_x) < Math.abs(tmp)) {
                        blackQueens[index] = queen;
                    }
                } else {
                    existedBlackQueens[index] = true;
                    blackQueens[index] = queen;
                }
            }
        }

        List<List<Integer>> blackQueensList = new ArrayList<>();
        for (int[] blackQueen: blackQueens) {
            if (blackQueen == null) continue;
            ArrayList<Integer> blackQueenList = new ArrayList<>();
            blackQueenList.add(blackQueen[0]);
            blackQueenList.add(blackQueen[1]);
            blackQueensList.add(blackQueenList);
        }

        return blackQueensList;
    }
}
