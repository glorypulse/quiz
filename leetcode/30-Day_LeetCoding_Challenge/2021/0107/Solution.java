class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int[] charMap = new int[127];
        Arrays.fill(charMap, -1);
        int max = 0;
        int index = -1;
        for (int i = 0; i < length; i ++) {
            char c = s.charAt(i);
            if (charMap[c] >= 0) {
                index = Math.max(index, charMap[c]);
            }
            charMap[c] = i;
            max = Math.max(max, i - index);
        }
        return max;
    }
}
