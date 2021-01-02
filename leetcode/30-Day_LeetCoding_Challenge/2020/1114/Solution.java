class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int x = 0;
        int samples = 1;
        int round = minutesToTest / minutesToDie;
        while (samples < buckets) {
            x ++;
            samples *= (round + 1);
        }
        return x;
    }
}
