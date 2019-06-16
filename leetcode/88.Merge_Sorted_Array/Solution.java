class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;

        for (int l = nums1.length - 1; l >= 0; l --) {
            if (i < 0) {
                nums1[l] = nums2[j];
                j --;
            }  else if (j < 0 || nums1[i] >= nums2[j]) {
                nums1[l] = nums1[i];
                i --;
            } else {
                nums1[l] = nums2[j];
                j --;
            }
        }
    }
}
