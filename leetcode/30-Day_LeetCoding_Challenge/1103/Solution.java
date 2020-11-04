class Solution {
    public int maxPower(String s) {
        int point = 1;
        int max = 1;
        char prev = '\0';

        for (char c: s.toCharArray()) {
            if (c == prev) {
                point ++;
                max = Math.max(max, point);
            } else {
                prev = c;
                point = 1;
            }
        }
        return max;
    }
}
