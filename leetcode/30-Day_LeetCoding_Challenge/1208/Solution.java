class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int length = time.length; // length > 0

        int[] remains = new int[60];
        for (int i = 0; i < length; i ++) {
            remains[time[i] % 60] ++;
        }
        int count = 0;
        for (int n: new int[] { remains[0], remains[30] }) {
            n --;
            while (n > 0) {
                count += n;
                n --;
            }
        }

        for (int i = 1; i < 30; i ++) {
            count += remains[i] * remains[60 - i];
        }

        return count;
    }
}
