class Solution {
    public int minFlips(int a, int b, int c) {
        String aStr = String.format("%30s", Integer.toBinaryString(a)).replace(" ", "0");
        String bStr = String.format("%30s", Integer.toBinaryString(b)).replace(" ", "0");
        String cStr = String.format("%30s", Integer.toBinaryString(c)).replace(" ", "0");
        int length = 30;

        int count = 0;
        char aChar, bChar, cChar;
        for (int i = 0; i < length; i ++) {
            aChar = aStr.charAt(i);
            bChar = bStr.charAt(i);
            cChar = cStr.charAt(i);

            if (cChar == '0') {
                if (aChar != '0') {
                    count ++;
                    if (bChar != '0') {
                        count ++;
                    }
                } else if (bChar != '0') {
                    count ++;
                }
            } else {
                if (aChar == '0' && bChar == '0') count ++;
            }
        }
        return count;
    }
}
