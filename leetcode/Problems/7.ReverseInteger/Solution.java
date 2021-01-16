class Solution {
    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) {
            minus = true;
            x = -x;
        }
        String xStr = String.valueOf(x);
        long convertedX = 0;
        for (int i = xStr.length() - 1; i >= 0; i --) {
            int xDigit = xStr.charAt(i) - '0';
            convertedX = convertedX * 10 + xDigit;
        }

        if (minus && convertedX >= Integer.MAX_VALUE || !minus && convertedX > Integer.MAX_VALUE) {
            return 0;
        }
        if (minus) {
            convertedX = -convertedX;
        }
        return (int)convertedX;
    }
}
