import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> beforeMap = new HashMap<>();
        int current = 0, length = 0, max = 0;
        Integer beforeIndex;
        for (char c: s.toCharArray()) {
            length ++;
            beforeIndex = beforeMap.get(c);
            if (beforeIndex == null) {
                current = Math.min(length, current + 1);
            } else {
                current = Math.min(length - beforeIndex, current + 1);
            }
            if (max < current) {
                max = current;
            }
            beforeMap.put(c, length);
        }

        return max;
    }
}
