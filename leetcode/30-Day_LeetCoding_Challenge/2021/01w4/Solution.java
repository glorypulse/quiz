class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS == lengthT) return replaceCheck(s, t);
        if (Math.abs(lengthS - lengthT) != 1) return false;
        if (lengthS > lengthT) {
            String tmp = s;
            s = t;
            t = tmp;
        }
        return insertCheck(s, t);
    }

    boolean replaceCheck(String s, String t) {
        int length = s.length();
        boolean oneEdit = false;
        for (int i = 0; i < length; i ++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (oneEdit) {
                    return false;
                }
                oneEdit = true;
            }
        }
        return oneEdit;
    }

    boolean insertCheck(String s, String t) {
        int length = s.length();
        boolean oneEdit = false;
        int i = 0;
        while (i < length) {
            if (oneEdit) {
                if (s.charAt(i) != t.charAt(i + 1)) {
                    return false;
                }
            } else {
                if (s.charAt(i) != t.charAt(i)) {
                    oneEdit = true;
                    continue;
                }
            }
            i ++;
        }
        return true;
    }
}
