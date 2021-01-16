class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int score = 0;
        for (int i = length - 1; i >= length - k; i --) {
            score += cardPoints[i];
        }
        int max = score;
        for (int i = 0; i < k; i ++) {
            score += cardPoints[i] - cardPoints[length - k + i];
            max = Math.max(max, score);
        }
        return max;
    }
}
