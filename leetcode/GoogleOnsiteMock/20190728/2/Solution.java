/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        // 1.peekを求める
        int left = 0, right = length - 1, mid = 0;
        int midValue, mlValue, mrValue;
        while (left <= right) {
            mid = (left + right) / 2;

            if (mid == 0) mid += 1;
            if (mid == length - 1) mid -= 1;

            midValue = mountainArr.get(mid);
            mlValue = mountainArr.get(mid - 1);
            mrValue = mountainArr.get(mid + 1);

            if (midValue > mlValue && midValue > mrValue) {
                break;
            }
            if (midValue > mlValue && midValue < mrValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int peek = mid;

        // 2.左側から探索
        left = 0;
        right = peek;
        while (left <= right) {
            mid = (left + right) / 2;
            midValue = mountainArr.get(mid);

            if (midValue == target) return mid;
            if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 3.右側から探索
        left = peek + 1;
        right = length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            midValue = mountainArr.get(mid);

            if (midValue == target) return mid;
            if (midValue > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
