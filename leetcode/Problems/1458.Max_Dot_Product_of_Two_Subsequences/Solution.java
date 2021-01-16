class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[][] matrix = new int[l1][l2];
        matrix[0][0] = nums1[0] * nums2[0];

        for (int i = 1; i < l2; i ++) {
            matrix[0][i] = Math.max(nums1[0] * nums2[i], matrix[0][i - 1]);
        }
        for (int i = 1; i < l1; i ++) {
            matrix[i][0] = Math.max(nums1[i] * nums2[0], matrix[i - 1][0]);
        }

        for (int i = 1; i < l1; i ++) {
            for (int j = 1; j < l2; j ++) {
                int val = nums1[i] * nums2[j];
                matrix[i][j] = Math.max(val,
                                        Math.max(matrix[i - 1][j - 1] + val,
                                                 Math.max(matrix[i - 1][j - 1],
                                                          Math.max(matrix[i][j - 1],
                                                                   matrix[i - 1][j]))));
            }
        }
        return matrix[l1 - 1][l2 - 1];
    }
}
