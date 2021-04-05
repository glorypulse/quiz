class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        Integer[] indexes = new Integer[length];
        int stacking = 0;
        int max = 0;
        for (int i = 0; i < length; i ++) {
            if (s.charAt(i) == '(') {
                if (indexes[stacking] == null) {
                    indexes[stacking] = i;
                }
                stacking ++;
            } else {
                indexes[stacking] = null;
                if (stacking > 0) {
                    stacking --;
                    max = Math.max(max, i - indexes[stacking] + 1);
                }
            }
        }
        return max;
    }
}
