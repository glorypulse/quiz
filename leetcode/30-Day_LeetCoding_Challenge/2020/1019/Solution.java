class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length == 0) return -1;
        int count = countRotations(A[0], A, B);
        if (count >= 0) return count;
        count = countRotations(B[0], A, B);
        return count;
    }

    int countRotations(int base, int[] orig, int[] other) {
        int countOrig = 0;
        int countOther = 0;
        for (int i = 0; i < orig.length; i ++) {
            if (base != orig[i] && base != other[i]) return -1;
            if (base != orig[i]) {
                countOrig ++;
            } else if (base != other[i]) {
                countOther ++;
            }
        }
        return Math.min(countOrig, countOther);
    }
}
