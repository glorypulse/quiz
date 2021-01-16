class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] charCounts = new int[26];
        for (char c: text.toCharArray()) {
            charCounts[c - 'a'] ++;
        }

        int count = charCounts['b' - 'a'];
        String balloon1 = "an";
        String balloon2 = "lo";
        for (char c: balloon1.toCharArray()) {
            if (charCounts[c - 'a'] < count) {
                count = charCounts[c - 'a'];
            }
        }

        for (char c: balloon2.toCharArray()) {
            if (charCounts[c - 'a'] / 2 < count) {
                count = charCounts[c - 'a'] / 2;
            }
        }

        return count;
    }
}
