class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        for (char c1: word1.toCharArray()) {
            counts1[c1 - 'a'] ++;
        }
        for (char c2: word2.toCharArray()) {
            if (counts1[c2 - 'a'] == 0) return false;
            counts2[c2 - 'a'] ++;
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        for (int i = 0; i < 26; i ++) {
            if (counts1[i] != counts2[i]) return false;
        }
        return true;
    }
}
