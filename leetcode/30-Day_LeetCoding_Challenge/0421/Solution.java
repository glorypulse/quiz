/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> bmSize = binaryMatrix.dimensions();
        int n = bmSize.get(0);
        int m = bmSize.get(1);

        int x = 0;
        int y = m - 1;
        while (y >= 0 && x < n) {
            if (binaryMatrix.get(x, y) == 1) {
                y --;
            } else {
                x ++;
            }
        }

        if (x == n && y == m - 1) return -1;
        return y + 1;
    }
}
