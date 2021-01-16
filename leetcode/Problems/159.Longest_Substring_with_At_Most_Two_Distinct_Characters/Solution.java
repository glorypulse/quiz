class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char oneChar = '\0';
        char[] twoChars = new char[2];
        Arrays.fill(twoChars, '\0');

        int oneCount = 0;
        int twoCount = 0;
        int max = 0;

        for (char c: s.toCharArray()) {
            if (oneChar == c) {
                oneCount ++;
                twoCount ++;
            } else {
                if (twoChars[0] == c || twoChars[1] == c) {
                    twoCount ++;
                } else {
                    twoChars[0] = oneChar;
                    twoChars[1] = c;
                    twoCount = oneCount + 1;
                }

                oneChar = c;
                oneCount = 1;
            }
            if (max < twoCount) max = twoCount;
        }

        return max;
    }
}
