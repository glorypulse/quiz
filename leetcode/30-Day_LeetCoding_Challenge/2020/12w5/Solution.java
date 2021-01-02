class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return k;
        int length = s.length();
        int left = 0, right = 0;

        int max = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        while (right < length) {
            int distinct = countMap.size();
            if (distinct <= k) {
                max = Math.max(max, right - left);
                char c = s.charAt(right);
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
                right ++;
            } else {
                char c = s.charAt(left);
                int count = countMap.get(c) - 1;
                if (count == 0) {
                    countMap.remove(c);
                } else {
                    countMap.put(c, count);
                }
                left ++;
            }
        }
        if (countMap.size() <= k) {
            max = Math.max(max, length - left);
        }
        return max;
    }
}
