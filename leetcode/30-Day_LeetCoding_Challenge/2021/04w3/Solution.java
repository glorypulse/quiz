class Solution {
    public int minSwaps(int[] data) {
        int oneCount = 0;
        for (int num: data) {
            oneCount += num;
        }
        int curCount = 0;
        for (int i = 0; i < oneCount; i ++) {
            curCount += data[i];
        }
        int min = oneCount - curCount;
        for (int i = oneCount; i < data.length; i ++) {
            curCount += data[i] - data[i - oneCount];
            min = Math.min(min, oneCount - curCount);
        }
        return min;
    }
}
