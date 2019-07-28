class Solution {
    public String alphabetBoardPath(String target) {
        int[][] board = new int[26][2];
        int i;
        for (i = 0; i < 26; i++) {
            board[i][0] = i / 5;
            board[i][1] = i % 5;
        }

        int ci = 0, cj = 0, ti, tj;
        StringBuilder sb = new StringBuilder();
        for (char c: target.toCharArray()) {
            ti = board[c - 'a'][0];
            tj = board[c - 'a'][1];

            while (cj > tj) {
                sb.append('L');
                cj--;
            }
            while (ci < ti) {
                sb.append('D');
                ci++;
            }
            while (ci > ti) {
                sb.append('U');
                ci--;
            }
            while (cj < tj) {
                sb.append('R');
                cj++;
            }
            sb.append('!');
        }
        return sb.toString();
    }
}
