class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] counts = new int[1001];
        for (int a: A) {
            counts[a] ++;
        }

        for (int n = 1000; n >= 0; n --) {
            if (counts[n] == 1) {
                return n;
            }
        }
        return -1;
    }
}
