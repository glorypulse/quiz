class Solution {
    int target = 0;
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length; // m > 0, n > 0;
        for (int i = 0; i < m; i ++) {
            target = Math.max(target, mat[i][0]);
        }
        int[] lefts = new int[m];
        for (int i = 0; i < m; i ++) {
            int left = lefts[i];
            int right = n - 1;
            boolean exist = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (mat[i][mid] == target) {
                    exist = true;
                    break;
                } else if (mat[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (!exist) {
                if (left >= n) return -1;
                while (left > 0 && mat[i][left] > target) {
                    left --;
                }
                target = mat[i][left + 1];
                i = 0;
                continue;
            }
        }
        return target;
    }
}
