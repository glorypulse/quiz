class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        int zero = 'A' - 1;
        for (char c: s.toCharArray()) {
            num = num * 26 + (c - zero);
        }
        return num;
    }
}
