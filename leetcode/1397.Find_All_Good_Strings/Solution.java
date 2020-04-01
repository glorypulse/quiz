class Solution {
    int countGoodStrings(String preStr, int size, String start, String end, String evil) {
        if (preStr.contains(evil)) return 0;
        if (size == 0) return 1;
        char startChar = start.charAt(0);
        char endChar = end.charAt(0);
        String startNext = start.substring(1);
        String aaaNext = repeat('a', size - 1);
        String endNext = end.substring(1);
        String zzzNext = repeat('z', size - 1);
        int count = 0;

        if (startChar == endChar) {
            count += countGoodStrings(preStr + startChar, size - 1, startNext, endNext, evil);
        } else {
            // c == startChar
            count += countGoodStrings(preStr + startChar, size - 1, startNext, zzzNext, evil);
            // c > startChar, c < endChar
            for (char c = (char)(startChar + 1); c < endChar; c ++) {
                count += countGoodStrings(preStr + c, size - 1, aaaNext, zzzNext, evil);
            }
            // c == endChar
            count += countGoodStrings(preStr + endChar, size - 1, aaaNext, endNext, evil);
        }
        return count;
    }

    String repeat(char c, int n) {
        var sb = new StringBuilder();
        while(n-- > 0) sb.append(c);
        return sb.toString();
    }

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        return countGoodStrings("", n, s1, s2, evil);
    }
}
