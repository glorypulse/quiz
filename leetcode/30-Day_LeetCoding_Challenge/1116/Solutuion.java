class Solution {
    public int longestMountain(int[] A) {
        int length = A.length;
        if (length == 0) return 0;
        boolean isMountain = false;
        int count = 1;
        int max = 0;

        for (int i = 1; i < length; i ++) {
            if (isMountain) {
                if (A[i - 1] > A[i]) {
                    count ++;
                    max = Math.max(max, count);
                } else if (A[i - 1] < A[i]) {
                    count = 2;
                    isMountain = false;
                } else {
                    count = 1;
                    isMountain = false;
                }
            } else {
                if (A[i - 1] < A[i]) {
                    count ++;
                } else if (A[i - 1] > A[i] && count >= 2) {
                    isMountain = true;
                    count ++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
        return max;
    }
}
