class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int length = A.length;
        int count = 0;
        for (int start = 0; start < length - 2; start ++) {
            int diff = A[start + 1] - A[start];
            for (int end = start + 2; end < length; end ++) {
                if (A[end] - A[end - 1] == diff) {
                    count ++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
