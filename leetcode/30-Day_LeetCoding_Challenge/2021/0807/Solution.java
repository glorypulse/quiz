class Solution {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] palindromeMatrix = new boolean[length][length];
        for (int end = 0; end < length; end ++) {
            palindromeMatrix[end][end] = true;
            for (int start = 0; start < end; start ++) {
                if (s.charAt(start) == s.charAt(end) &&
                    (start + 1 == end || palindromeMatrix[start + 1][end - 1])) {
                    palindromeMatrix[start][end] = true;
                }
            }
        }

        int[] minCuts = new int[length + 1];
        Arrays.fill(minCuts, length);
        minCuts[0] = 0;
        for (int end = 0; end < length; end ++) {
            for (int start = 0; start <= end; start ++) {
                if (palindromeMatrix[start][end]) {
                    minCuts[end + 1] = Math.min(minCuts[end + 1], minCuts[start] + 1);
                }
            }
        }

        return minCuts[length] - 1;
    }
}
