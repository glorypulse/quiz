class Solution {
    char[] allStrobo = {'0', '1', '6', '8', '9'};

    char upsideDown(char c) {
        switch(c) {
        case '6':
            return '9';
        case '9':
            return '6';
        }
        return c;
    }

    int makeStrobo(int index, int n, char[] strobo, String low, String high) {
        if (low.isEmpty() && high.isEmpty()) {
            if (index == n / 2 && n % 2 == 0 || index == n / 2 + 1 && n % 2 == 1) {
                return 1;
            }
            int p = 5;
            if (index == 0) p --;
            if (index == n / 2 && n % 2 == 1) p -= 2;
            return p * makeStrobo(index + 1, n, null, "", "");
        }

        if (index == n / 2 && n % 2 == 0 || index == n / 2 + 1 && n % 2 == 1) {
            if (!low.isEmpty()) {
                if (Long.valueOf(new String(strobo)) < Long.valueOf(low)) return 0;
            }
            if (!high.isEmpty()) {
                if (Long.valueOf(new String(strobo)) > Long.valueOf(high)) return 0;
            }
            return 1;
        }


        char l = Character.MIN_VALUE;
        if (!low.isEmpty()) l = low.charAt(index);
        char h = Character.MAX_VALUE;
        if (!high.isEmpty()) h = high.charAt(index);
        int stroboNum = 0;
        for (char c: allStrobo) {
            if (index == 0 && c == '0' && n != 1) continue;
            if (index == n / 2 && n % 2 == 1 && (c == '6' || c == '9')) continue;
            if (c < l || c > h) continue;
            if (c > l && c < h) {
                stroboNum += makeStrobo(index + 1, n, strobo, "", "");
            }
            strobo[index] = c;
            strobo[n - 1 - index] = upsideDown(c);
            if (c == l && c == h) {
                stroboNum += makeStrobo(index + 1, n, strobo, low, high);
            } else if (c == l) {
                stroboNum += makeStrobo(index + 1, n, strobo, low, "");
            } else if (c == h) {
                stroboNum += makeStrobo(index + 1, n, strobo, "", high);
            }
        }
        return stroboNum;
    }

    public int strobogrammaticInRange(String low, String high) {
        int lowLength = low.length();
        int highLength = high.length();
        char[] strobo = new char[lowLength];
        if (lowLength > highLength) return 0;
        if (lowLength == highLength) {
            return makeStrobo(0, lowLength, strobo, low, high);
        }
        int stroboNum = 0;
        stroboNum += makeStrobo(0, lowLength, strobo, low, "");
        for (int i = lowLength + 1; i <= highLength; i++) {
            if (i == highLength) {
                strobo = new char[highLength];
                stroboNum += makeStrobo(0, highLength, strobo, "", high);
                break;
            }
            stroboNum += makeStrobo(0, i, null, "", "");
        }
        return stroboNum;
    }
}
