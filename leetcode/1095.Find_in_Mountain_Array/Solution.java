/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

import java.util.Arrays;

class Solution {
    final int INIT_NUM = -2;
    int[] memoArr;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        memoArr = new int[length];
        Arrays.fill(memoArr, INIT_NUM);
        int found = binarySearchInMountainArray(0, length - 1, target, mountainArr, memoArr);
        if (found <= 0) return found;

        int value = getMountainArray(found, mountainArr, memoArr);
        int value_left = getMountainArray(found - 1, mountainArr, memoArr);
        if (value < value_left) {
            int found_left = binarySearchInMountainArray(0, found - 1, target, mountainArr, memoArr);
            if (found_left >= 0) return found_left;
        }
        return found;
    }

    private int binarySearchInMountainArray(int left, int right, int target, MountainArray mountainArr, int[] memoArr) {
        if (left >= right) return -1;

        int index = (left + right) / 2;
        int value = getMountainArray(index, mountainArr, memoArr);
        if (value == target) return index;

        int left_value = getMountainArray(left, mountainArr, memoArr);
        int right_value = getMountainArray(right, mountainArr, memoArr);

        if (left_value == target) return left;
        if (right_value == target) return right;

        if (left_value < value && value < right_value) {
            // 山の左
            if (target < value) {
                return binarySearchInMountainArray(left, index - 1, target, mountainArr, memoArr);
            } else {
                return binarySearchInMountainArray(index + 1, right, target, mountainArr, memoArr);
            }
        } else if (left_value > value && value > right_value) {
            // 山の右
            if (target > value) {
                return binarySearchInMountainArray(left, index - 1, target, mountainArr, memoArr);
            } else {
                return binarySearchInMountainArray(index + 1, right, target, mountainArr, memoArr);
            }
        } else {
            // 山のピークを含む
            int found = -1;
            if (target > left_value) {
                found = binarySearchInMountainArray(left, index - 1, target, mountainArr, memoArr);
            }
            if (found >= 0) return found;
            if (target > right_value) {
                return binarySearchInMountainArray(index + 1, right, target, mountainArr, memoArr);
            }
            return found;
        }
    }

    private int getMountainArray(int index, MountainArray mountainArr, int[] memoArr) {
        if (memoArr[index] != INIT_NUM) return memoArr[index];
        int value = mountainArr.get(index);
        memoArr[index] = value; // メモ
        return value;
    }
}
