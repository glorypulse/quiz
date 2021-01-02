class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length; // length >= 1

        for (int i = 0; i < length; i ++) {
            int j = 0;
            int l = length - 1;
            while (l >= j) {
                int tmp = A[i][j];
                A[i][j] = A[i][l] ^ 1;
                A[i][l] = tmp ^ 1;
                j ++;
                l --;
            }
        }
        return A;
    }
}
