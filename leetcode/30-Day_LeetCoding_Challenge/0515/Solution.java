class Solution {
    public int maxSubarraySumCircular(int[] A) {
        long cur = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < A.length * 2; i ++) {
            cur += A[i % A.length];
            max = Math.max(max, cur);
            if (cur - max < min) {
                min = cur - max;
                index = i;
            }
        }
        index = (index + 1) % A.length;
        cur = 0;
        max = Integer.MIN_VALUE;

        for (int i = index; i < A.length + index; i ++) {
            cur += A[i % A.length];
            max = Math.max(max, cur);
            if (cur < 0) cur = 0;
        }

        return (int)max;
    }
}
