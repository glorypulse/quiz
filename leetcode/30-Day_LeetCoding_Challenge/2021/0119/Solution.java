class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) return s;
        int max = 1;
        int longestStart = 0;
        for (int start = 0; start < length - max; start ++) {
            int startC = s.charAt(start);
            int end = length - 1;
            while (end >= start + max) {
                if (s.charAt(end) == startC && checkPalindrome(s, start, end)) {
                    longestStart = start;
                    max = end - start + 1;
                    break;
                }
                end --;
            }
        }
        return s.substring(longestStart, longestStart + max);
    }

    boolean checkPalindrome(String s, int start, int end) {
        int i = start;
        int j = end;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i ++;
            j --;
        }
        if (i < j) {
            return false;
        }
        return true;
    }
}
