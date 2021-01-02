class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[] winned = new Boolean[n + 1];
        winned[0] = false;
        winned[1] = true;

        return winGame(n, winned);
    }

    boolean winGame(int n, Boolean[] winned) {
        if (winned[n] != null) return winned[n];

        for (long r = n / 2; r >= 1; r --) {
            if (r * r > n) continue;
            if (!winGame((int)(n - r * r), winned)) { // B lose
                winned[n] = true;
                break;
            }
        }
        if (winned[n] == null) {
            winned[n] = false;
        }
        return winned[n];
    }
}
