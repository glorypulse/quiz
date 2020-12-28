class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int secondPrev = 1;
        int prev = 0;
        int prevNum = s.charAt(0) - '0';
        if (prevNum > 0) prev ++;
        for (int i = 1; i < length; i ++) {
            int currentNum = s.charAt(i) - '0';
            int twoDigits = prevNum * 10 + currentNum;
            int current = currentNum > 0 ? prev : 0;
            if (twoDigits > 9 && twoDigits <= 26) {
                current += secondPrev;
            }
            prevNum = currentNum;
            secondPrev = prev;
            prev = current;
        }
        return prev;
    }
}
