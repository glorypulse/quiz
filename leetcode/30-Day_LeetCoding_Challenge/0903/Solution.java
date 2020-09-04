class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length == 0) return false;
        char start = s.charAt(0);
        for (int i = 1; i < length; i ++) {
            if (length % i == 0 && start == s.charAt(i)) {
                boolean patterned = true;
                for (int j = 0; j < i; j ++) {
                    int n = 1;
                    char c = s.charAt(j);
                    while (n * i + j < length) {
                        if (s.charAt(n * i + j) != c) {
                            patterned = false;
                            break;
                        }
                        n ++;
                    }
                    if (!patterned) break;
                }
                if (patterned) return true;
            }
        }
        return false;
    }
}
