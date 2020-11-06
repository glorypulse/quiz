class Solution {
    public int minCostToMoveChips(int[] position) {
        int length = position.length;
        if (length == 0) return 0;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < length; i ++) {
            if (position[i] % 2 == 0) {
                even ++;
            } else {
                odd ++;
            }
        }
        return Math.min(even, odd);
    }
}
