class Solution {
    public boolean hasAllCodes(String s, int k) {
        int length = s.length();
        if (length <= 1) return false;
        Set<String> codes = new HashSet<>();
        int allSize = (int)Math.pow(2, k);
        for (int i = 0; i <= length - k; i ++) {
            codes.add(s.substring(i, i + k));
            if (codes.size() >= allSize) return true;
        }
        return false;
    }
}
