class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) return false;
        int[] s1Count = new int[26];

        for (char c1: s1.toCharArray()) {
            s1Count[c1 - 'a'] ++;
        }

        int falseCount = 0;

        for (int i = 0; i < s2Len; i ++) {
            if (i >= s1Len) {
                char oldC2 = s2.charAt(i - s1Len);
                int oldIndex = oldC2 - 'a';
                s1Count[oldIndex] ++;
                if (s1Count[oldIndex] <= 0) {
                    falseCount --;
                }
            }

            char c2 = s2.charAt(i);
            int index = c2 - 'a';
            s1Count[index] --;
            if (s1Count[index] < 0) {
                falseCount ++;
            }

            if (i < s1Len - 1) continue;
            if (falseCount == 0) return true;
        }
        return false;
    }
}
