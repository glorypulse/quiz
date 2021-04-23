class Solution {
    public int countBinarySubstrings(String s) {
        char now = '0';
        int[] count = new int[2];
        int total = 0;
        for (char cur: s.toCharArray()) {
            int index = cur - '0';
            if (cur == now) {
                count[index] ++;
            } else {
                now = cur;
                count[index] = 1;
            }
            if (index == 0 && count[1] >= count[0] ||
                index == 1 && count[0] >= count[1]) {
                total ++;
            }
        }
        return total;
    }
}
