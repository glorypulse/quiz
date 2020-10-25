class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int length = tokens.length;
        if (length == 0) return 0;

        Arrays.sort(tokens);
        int power = P;
        int score = 0;
        int max = 0;

        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score ++;
                left ++;
            } else if (score > 0) {
                score --;
                power += tokens[right];
                right --;
            } else {
                break;
            }

            max = Math.max(max, score);
        }

        return max;
    }
}
