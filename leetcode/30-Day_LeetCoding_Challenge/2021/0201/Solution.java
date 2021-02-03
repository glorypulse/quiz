/**
 * Number of 1 Bits
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bit = 1;
        int count = 0;
        for (int i = 0; i < 32; i ++) {
            if ((n & bit) != 0) {
                count ++;
            }
            bit <<= 1;
        }
        return count;
    }
}
