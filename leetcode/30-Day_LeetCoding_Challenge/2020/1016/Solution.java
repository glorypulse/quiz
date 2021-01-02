class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        if (length == 0) return false;
        if (matrix[0].length == 0) return false;

        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= matrix.length) return false;
        int row = matrix[left][0] > target ? left - 1 : left;
        if (row < 0) return false;

        left = 0;
        right = matrix[row].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
