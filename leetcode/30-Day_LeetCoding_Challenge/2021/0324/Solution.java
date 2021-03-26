class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int length = A.length;
        int[][] bIndex = new int[length][2];
        for (int i = 0; i < length; i ++) {
            bIndex[i][0] = i;
            bIndex[i][1] = B[i];
        }

        Arrays.sort(bIndex, (a, b) -> b[1] - a[1]);
        Arrays.sort(A);

        int[] ans = new int[length];
        int i = 0;
        int ai = length - 1;
        int aj = 0;
        while (i < length) {
            if (A[ai] > bIndex[i][1]) {
                ans[bIndex[i][0]] = A[ai];
                i ++;
                ai --;
            } else {
                ans[bIndex[i][0]] = A[aj];
                i ++;
                aj ++;
            }
        }
        return ans;
    }
}
