class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        TreeMap<Integer, Integer> commonMap = new TreeMap<>(Collections.reverseOrder());
        int length2 = text2.length();
        int max = 0;
        for (char c: text1.toCharArray()) {
            for (int i = length2 - 1; i >= 0; i --) {
                if (c == text2.charAt(i)) {
                    int value = 0;
                    for (Map.Entry<Integer, Integer> entry: commonMap.entrySet()) {
                        if (entry.getValue() < i) {
                            value = entry.getKey();
                            break;
                        }
                    }
                    value ++;
                    commonMap.put(value, Math.min(i, commonMap.getOrDefault(value, length2)));
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }
}
