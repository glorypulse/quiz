class Solution {
    public int minFlipsMonoIncr(String s) {
        int length = s.length();
        int[] zeros = new int[length];
        int[] ones = new int[length];

        zeros[0] = s.charAt(0) != '0' ? 1 : 0;
        ones[length - 1] = s.charAt(length - 1) != '1' ? 1 : 0;

        for (int i = 1; i < length; i ++) {
            int j = length - 1 - i;
            zeros[i] = zeros[i - 1] + (s.charAt(i) != '0' ? 1 : 0);
            ones[j] = ones[j + 1] + (s.charAt(j) != '1' ? 1 : 0);
        }
        int min = Math.min(zeros[length - 1], ones[0]);
        for (int i = 0; i < length - 1; i ++) {
            min = Math.min(min, zeros[i] + ones[i + 1]);
        }
        return min;
    }
}
