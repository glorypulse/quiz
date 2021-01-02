class Solution {
    public String decodeAtIndex(String S, int K) {
        long length = 0;
        int indexS = 0;

        while (length < K) {
            char c = S.charAt(indexS);
            if (Character.isDigit(c)) {
                length *= c - '0';
            } else {
                length ++;
            }
            indexS ++;
        }
        indexS --;
        int index = K - 1;
        while (indexS > 0) {
            char c = S.charAt(indexS);
            if (Character.isDigit(c)) {
                length /= c - '0';
                index %= length;
            } else if (index + 1 == length) {
                break;
            } else {
                length --;
            }
            indexS --;
        }

        return String.valueOf(S.charAt(indexS));
    }
}
