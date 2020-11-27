class Solution {
    public int longestSubstring(String s, int k) {
        Set<Character> ngSet = new HashSet<>();
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            int count = ++counts[c - 'a'];
            if (count < k) {
                ngSet.add(c);
            } else {
                ngSet.remove(c);
            }
        }

        if (ngSet.isEmpty()) return s.length();
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (Character ng: ngSet) {
            sb.append(ng + "|");
        }
        sb.deleteCharAt(sb.length() - 1);
        for (String substr: s.split(sb.toString())) {
            if (substr.length() == 0) continue;
            max = Math.max(max, longestSubstring(substr, k));
        }
        return max;
    }
}
