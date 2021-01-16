import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int length = colsum.length;
        int[][] answerMatrix = new int[2][length];
        List<Integer> oneIndices = new ArrayList<>();
        int sum;
        for (int i = 0; i < length; i ++) {
            sum = colsum[i];
            switch(sum) {
            case 2:
                answerMatrix[0][i] = 1;
                answerMatrix[1][i] = 1;
                upper --;
                lower --;
                break;
            case 1:
                oneIndices.add(i);
                break;
            }
        }

        for (int index: oneIndices) {
            if (upper > 0) {
                answerMatrix[0][index] = 1;
                upper --;
            } else {
                answerMatrix[1][index] = 1;
                lower --;
            }
        }

        List<List<Integer>> answerMatrixList = new ArrayList<>();
        if (upper == 0 && lower == 0) {
            for (int row = 0; row < 2; row ++) {
                List<Integer> rowList = new ArrayList<>();
                answerMatrixList.add(rowList);
                for (int col = 0; col < length; col ++) {
                    rowList.add(answerMatrix[row][col]);
                }
            }
        }

        return answerMatrixList;
    }
}
