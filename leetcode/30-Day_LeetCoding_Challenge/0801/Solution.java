class Solution {
    public boolean detectCapitalUse(String word) {
        boolean capitalized = true;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (c <= 'Z') {
                if (!capitalized) {
                    return false;
                }
            } else {
                if (capitalized && i > 1) {
                    return false;
                }
                capitalized = false;
            }
        }
        return true;
    }
}
