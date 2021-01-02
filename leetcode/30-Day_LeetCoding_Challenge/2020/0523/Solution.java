import java.util.ArrayList;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        int[] a;
        int[] b;
        int start, end;
        ArrayList<int[]> ret = new ArrayList<int[]>();

        while (i < A.length && j < B.length) {
            a = A[i];
            b = B[j];

            start = Math.max(a[0], b[0]);
            end = Math.min(a[1], b[1]);

            if (start <= end) {
                ret.add(new int[] { start, end });
            }

            if (a[1] < b[1]) {
                i ++;
            } else if (a[1] > b[1]) {
                j ++;
            } else {
                i ++;
                j ++;
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
