class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < 26; i ++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        String prev = words[0];
        int prevLength = prev.length();
        for (int i = 1; i < words.length; i ++) {
            String cur = words[i];
            int length = cur.length();
            int max = Math.min(prevLength, length);
            for (int j = 0; j < max; j ++) {
                int p = orderMap[prev.charAt(j) - 'a'];
                int c = orderMap[cur.charAt(j) - 'a'];
                if (p == c) {
                    if (j == max - 1 && length < prevLength) {
                        return false;
                    }
                } else if (c < p) {
                    return false;
                } else {
                    break;
                }
            }
            prev = cur;
        }
        return true;
    }
}
