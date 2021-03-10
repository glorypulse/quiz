class Solution {
    public int removePalindromeSub(String s) {
        int length = s.length();
        if (length <= 1) return length;
        for (int i = 0; i < length / 2; i ++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
