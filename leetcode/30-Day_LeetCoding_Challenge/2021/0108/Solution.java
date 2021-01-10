class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) {
                return false;
            }
            if (j1 + 1 < word1[i1].length()) {
                j1 ++;
            } else {
                i1 ++;
                j1 = 0;
            }
            if (j2 + 1 < word2[i2].length()) {
                j2 ++;
            } else {
                i2 ++;
                j2 = 0;
            }
        }

        if (i1 < word1.length || i2 < word2.length) {
            return false;
        }
        return true;
    }
}
