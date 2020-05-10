class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trustCount = new int[N + 1];
        int trustLength = trust.length;
        for (int[] t: trust) {
            trustCount[t[0]] = -trustLength;
            trustCount[t[1]] ++;
        }

        for (int i = 1; i < N + 1; i ++) {
            if (trustCount[i] == N - 1) return i;
        }
        return -1;
    }
}
