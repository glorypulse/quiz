class Solution {
    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] shortestCounts = new int[length];
        Arrays.fill(shortestCounts, length - 1);
        int count = 0;
        for (int i = s.indexOf(c); i < length; i ++) {
            if (s.charAt(i) == c) {
                count = 0;
            } else {
                count ++;
            }
            shortestCounts[i] = count;
        }

        for (int i = s.lastIndexOf(c); i >= 0; i --) {
            if (s.charAt(i) == c) {
                count = 0;
            } else {
                count ++;
                shortestCounts[i] = Math.min(shortestCounts[i], count);
            }
        }
        return shortestCounts;
    }
}
