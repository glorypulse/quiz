class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int leftI = 0;
        int leftJ = 0;
        int rightI = m - 1;
        int rightJ = n - 1;

        while (leftI <= rightI && leftJ <= rightJ) {
            int left, right;
            if (leftI <= rightI) {
                left = leftI;
                right = rightI;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (matrix[mid][leftJ] > target) {
                        right = mid - 1;
                    } else if (matrix[mid][leftJ] < target) {
                        if (mid == rightI || matrix[mid + 1][leftJ] > target) {
                            left = mid;
                            break;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        return true;
                    }
                }
                rightI = left;
            }

            if (leftJ <= rightJ) {
                left = leftJ;
                right = rightJ;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (matrix[leftI][mid] > target) {
                        right = mid - 1;
                    } else if (matrix[leftI][mid] < target) {
                        if (mid == rightJ || matrix[leftI][mid + 1] > target) {
                            left = mid;
                            break;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        return true;
                    }
                }
                rightJ = left;
            }

            leftI ++;
            leftJ ++;
        }
        return false;
    }
}
