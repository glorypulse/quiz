class Solution {
    public int missingNumber(int[] arr) {
        int diff = arr[1] - arr[0];
        int predict = arr[1] + diff;
        if (arr[2] == predict) {
            predict = arr[2] + diff;
        } else if (diff > 0 && arr[2] < predict ||
                   diff < 0 && arr[2] > predict) {
            diff = arr[2] - arr[1];
            return arr[1] - diff;
        } else {
            return predict;
        }

        for (int i = 3; i < arr.length; i ++) {
            if (arr[i] == predict) {
                predict = arr[i] + diff;
            } else {
                break;
            }
        }
        return predict;
    }
}
