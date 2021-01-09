class Solution {
    public int findKthPositive(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) return k;
        int count = 0;
        int prev = 0;
        for (int i = 0; i < length; i ++) {
            int missingCount = arr[i] - prev - 1;
            if (count + missingCount >= k) {
                return k - count + prev;
            } else {
                count += missingCount;
            }
            prev = arr[i];
        }
        return k - count + prev;
    }
}
