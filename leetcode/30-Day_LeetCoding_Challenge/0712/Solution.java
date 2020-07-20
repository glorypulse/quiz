public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32 - binary.length(); i ++) {
            sb.append(0);
        }
        sb.append(binary);
        sb.reverse();
        
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}