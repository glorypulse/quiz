class Solution {
    public int balancedString(String s) {
        // Q, W, R, E
        int[] countArray = new int[4];

        for (char c: s.toCharArray()) {
            switch(c) {
            case 'Q': countArray[0]++; break;
            case 'W': countArray[1]++; break;
            case 'R': countArray[2]++; break;
            case 'E': countArray[3]++; break;
            }
        }

        int maxTimes = s.length / 4;
        int times = 0;
        for (int count: countArray) {
            if (count > maxTimes) {
                times += (maxTimes - count);
            }
        }
        return times;
    }
}

// "WWEQERQWQWWRWWERQWEQ"
// "WWWWWWWWEEEEQQQQQRRR"
// "WEQRWEQR"
