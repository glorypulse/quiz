class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int length = s.length();
        if (length == 0) return 0;
        char[] two = new char[2];
        char one = s.charAt(0);
        two[0] = one;
        int countTwo = 1, countOne = 1;
        int max = 1;

        for (int i = 1; i < length; i ++) {
            char c = s.charAt(i);
            if (one == c) {
                countTwo ++;
                countOne ++;
            } else {
                if (two[0] == c || two[1] == c) {
                    countTwo ++;
                } else {
                    two = new char[]{ c, one };
                    countTwo = countOne + 1;
                }
                one = c;
                countOne = 1;
            }
            max = Math.max(max, countTwo);
        }
        return max;
    }
}
