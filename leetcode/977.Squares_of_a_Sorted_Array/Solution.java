class Solution {
    public int[] sortedSquares(int[] A) {
        int sign_i = indexSign(A);
        int i = sign_i - 1;
        int j = sign_i;


        int[] ret = new int[A.length];
        for (int l = 0; l < A.length; l ++) {
            if (i < 0) {
                ret[l] = A[j] * A[j];
                j ++;
            }
            else if (j >= A.length || -A[i] <= A[j]) {
                ret[l] = A[i] * A[i];
                i --;
            }
            else {
                ret[l] = A[j] * A[j];
                j ++;
            }
        }

        return ret;
    }

    private int indexSign(int[] A) {
        int index_sign = A.length;
        if (A[A.length - 1] < 0) return index_sign;
        for (int i = 0; i < A.length; i ++) {
            if (A[i] >= 0) {
                index_sign = i;
                break;
            }
        }
        return index_sign;
    }
}
