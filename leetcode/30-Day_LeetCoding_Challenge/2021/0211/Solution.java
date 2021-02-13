class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letters = new int[26];
        for (char c: s.toCharArray()) {
            letters[c - 'a'] ++;
        }

        for (char d: t.toCharArray()) {
            letters[d - 'a'] --;
            if (letters[d - 'a'] < 0) return false;
        }
        return true;
    }
}
