class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1, tmp = 0;
        while (i < j) {
            while (A[i] % 2 == 0 && i < j) i++;
            while (A[j] % 2 != 0 && i < j) j--;
            if (i < j) {
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
