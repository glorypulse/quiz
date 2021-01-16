class Solution {
    public int maxScore(String s) {
        int score = 0;
        char[] charArray = s.toCharArray();
        for (char c: charArray) {
            if (c == '1') score ++;
        }
        if (charArray[0] == '0') {
            score ++;
        } else {
            score --;
        }
        int max = score;
        for (int i = 1; i < charArray.length - 1; i ++) {
            if (charArray[i] == '0') {
                score ++;
            } else {
                score --;
            }
            max = Math.max(max, score);
        }
        return max;
    }
}
