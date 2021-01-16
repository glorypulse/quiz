import java.util.ArrayList;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        int[] a;
        int[] b;
        ArrayList<int[]> ret = new ArrayList<int[]>();

        while( i < A.length && j < B.length) {
            a = A[i];
            b = B[j];

            // 閉区間がない場合
            if (a[1] < b[0]) {
                i ++;
                continue;
            }

            if (b[1] < a[0]) {
                j ++;
                continue;
            }

            // 閉区間がある場合
            int[] ret_interval = new int[2];
            if (a[0] <= b[0]) {
                ret_interval[0] = b[0];
            } else {
                ret_interval[0] = a[0];
            }

            if (a[1] <= b[1]) {
                ret_interval[1] = a[1];
                i ++;
            } else {
                ret_interval[1] = b[1];
                j ++;
            }

            ret.add(ret_interval);
        }

        return ret.toArray(new int[ret.size()][2]);
    }
}
