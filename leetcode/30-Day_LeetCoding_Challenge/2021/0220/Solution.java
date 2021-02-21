class Solution {
    public int romanToInt(String s) {
        int length = s.length();
        int num = 0;
        for (int i = 0; i < length; i ++) {
            switch (s.charAt(i)) {
            case 'I':
                if (i < length - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    num -= 1;
                } else {
                    num += 1;
                }
                break;
            case 'X':
                if (i < length - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    num -= 10;
                } else {
                    num += 10;
                }
                break;
            case 'C':
                if (i < length - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    num -= 100;
                } else {
                    num += 100;
                }
                break;
            case 'V':
                num += 5;
                break;
            case 'L':
                num += 50;
                break;
            case 'D':
                num += 500;
                break;
            case 'M':
                num += 1000;
                break;
            }
        }
        return num;
    }
}
