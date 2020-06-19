class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0, right = length - 1;
        int max = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = citations[mid];
            max = Math.max(max, Math.min(val, length - mid));
            if (val < length - mid) {
                left = mid + 1;
            } else if (val > length - mid) {
                right = mid - 1;
            } else {
                break;
            }
        }
        return max;
    }
}
