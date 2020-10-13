class Solution {
    public boolean buddyStrings(String A, String B) {
        int length = A.length();
        if (length != B.length()) return false;

        boolean swapped = false;
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        int[] letters = new int[26];
        boolean sameSwapped = false;
        for (int i = 0; i < length; i ++) {
            if (charA[i] != charB[i]) {
                if (swapped) return false;
                for (int j = i + 1; j < length; j ++) {
                    if (charA[i] == charB[j] && charB[i] == charA[j]) {
                        char tmp = charA[i];
                        charA[i] = charA[j];
                        charA[j] = tmp;
                        swapped = true;
                        break;
                    }
                }
                if (!swapped) return false;
            } else if (!sameSwapped) {
                letters[charA[i] - 'a'] ++;
                if (letters[charA[i] - 'a'] > 1) {
                    sameSwapped = true;
                }
            }
        }

        if (swapped) return true;
        return sameSwapped;
    }
}
