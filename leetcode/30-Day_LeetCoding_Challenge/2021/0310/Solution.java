class Solution {
    char[][] romans = new char[][] {
        { 'M', 'D', 'C' },
        { 'C', 'L', 'X' },
        { 'X', 'V', 'I' }
    };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            sb.append('M');
            num -= 1000;
        }


        StringBuilder tmpSb = new StringBuilder();

        int base = 100;

        for (int digit = 3; digit > 0; digit --) {
            int index = romans.length - digit;
            num += base;

            while (num - (num % base) > base) {
                if (num >= 10 * base) {
                    tmpSb.append(romans[index][0]);
                    num -= 10 * base;
                } else if (num >= 5 * base) {
                    tmpSb.append(romans[index][1]);
                    num -= 5 * base;
                } else if (num >= base) {
                    tmpSb.append(romans[index][2]);
                    num -= base;
                }
            }
            if (num < base) {
                tmpSb.append(romans[index][2]);
                tmpSb.reverse();
            } else {
                num -= base;
            }
            sb.append(tmpSb.toString());

            tmpSb.setLength(0);
            base /= 10;
        }
        return sb.toString();
    }
}
