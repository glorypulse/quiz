class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1, mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
            if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}
