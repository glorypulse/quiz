class Solution {
    public int longestPalindrome(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        char prev = ' ';
        int[] counts = new int[letters.length + 1];
        int count = 0;
        int max = 0;
        for (char c: letters) {
            if (c != prev) {
                counts[count] ++;
                max = Math.max(max, count);
                count = 1;
                prev = c;
            } else {
                count ++;
            }
        }
        counts[count] ++;
        max = Math.max(max, count);

        int length = 0;
        boolean odd = false;
        for (int i = 1; i <= max; i += 2) {
            length += (i - 1) * counts[i];
            if (!odd && counts[i] > 0) {
                length ++;
                odd = true;
            }
        }
        for (int i = 2; i <= max; i += 2) {
            length += i * counts[i];
        }

        return length;
    }
}
