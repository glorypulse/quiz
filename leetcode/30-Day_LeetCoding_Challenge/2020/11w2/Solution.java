class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int length = A.length;
        if (length == 0) return 0;
        Arrays.sort(A);

        int i = 0, j = length - 1;
        int max = -1;
        while (i < j) {
            while (j >= 0 && i < j && A[i] + A[j] >= K) j --;
            if (j < 0 || i >= j) break;
            max = Math.max(max, A[i] + A[j]);
            i ++;
        }
        return max;
    }
}
