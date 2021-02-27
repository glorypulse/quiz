class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> scoreStack = new Stack<>();
        int score = 0;
        boolean started = false;
        for (int i = 0; i < S.length(); i ++) {
            boolean starting = S.charAt(i) == '(';
            if (started) {
                if (starting) {
                    scoreStack.push(score);
                    score = 0;
                } else {
                    score += 1;
                    started = false;
                }
            } else {
                if (starting) {
                    started = true;
                } else {
                    score = score * 2 + scoreStack.pop();
                }
            }
        }
        return score;
    }
}
