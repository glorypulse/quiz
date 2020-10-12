class Solution {
    public String removeDuplicateLetters(String s) {
        int length = s.length();
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        boolean[] seen = new boolean[26];

        for (int i = length - 1; i >= 0; i --) {
            int ci = s.charAt(i) - 'a';
            if (lastIndex[ci] >= 0) continue;
            lastIndex[ci] = i;
        }

        char[] result = new char[26];
        int resultIndex = -1;
        for (int i = 0; i < length; i ++) {
            char c = s.charAt(i);
            int ci = c - 'a';
            if (seen[ci]) continue;
            while (resultIndex >= 0 && result[resultIndex] > c && lastIndex[result[resultIndex] - 'a'] > i) {
                seen[result[resultIndex --] - 'a'] = false;
            }
            result[++ resultIndex] = c;
            seen[ci] = true;
        }

        return String.valueOf(result, 0, resultIndex + 1);
    }
}
