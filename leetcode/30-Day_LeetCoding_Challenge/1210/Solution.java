class Solution {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        if (length < 3) return false;
        int i = 1;
        while (i < length) {
            if (arr[i - 1] < arr[i]) {
                i ++;
                continue;
            } else if (arr[i - 1] == arr[i] || i == 1) {
                return false;
            } else {
                break;
            }
        }
        if (i == length) return false;
        i ++;
        while (i < length) {
            if (arr[i - 1] > arr[i]) {
                i ++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
