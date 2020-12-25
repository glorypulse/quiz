class Solution {
    public int minSwaps(int[] data) {
        int length = data.length;
        int oneLength = 0;
        for (int i = 0; i < length; i ++) {
            if (data[i] == 1) oneLength ++;
        }

        int zeroCount = 0;
        for (int i = 0; i < oneLength; i ++) {
            if (data[i] == 0) zeroCount ++;
        }
        int zeroMin = zeroCount;
        for (int i = oneLength; i < length; i ++) {
            if (data[i - oneLength] == 0) {
                zeroCount --;
            }
            if (data[i] == 0) {
                zeroCount ++;
            }
            zeroMin = Math.min(zeroMin, zeroCount);
        }
        return zeroMin;
    }
}
