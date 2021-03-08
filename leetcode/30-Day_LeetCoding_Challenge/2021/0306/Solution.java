class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String>[] wordSet = new HashSet[26];
        for (int i = 0; i < 26; i ++) {
            wordSet[i] = new HashSet<>();
        }

        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int strLength = 0;
        for (String word: words) {
            char top = word.charAt(0);
            if (!wordSet[top - 'a'].contains(word)) {
                int length = word.length();
                for (int i = 0; i < length; i ++) {
                    char c = word.charAt(i);
                    wordSet[c - 'a'].add(word.substring(i));
                }
                strLength += length + 1;
            }
        }
        return strLength;
    }
}
