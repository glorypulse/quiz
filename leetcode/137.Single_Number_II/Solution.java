class Solution {
    public int singleNumber(int[] nums) {
        int[] binaryDigits = new int[32];
        for (int num: nums) {
            String b = Integer.toBinaryString(num);
            int length = b.length();
            for (int i = 0; i < length; i ++) {
                binaryDigits[i] += b.charAt(length - i - 1) - '0';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i --) {
            binaryDigits[i] = binaryDigits[i] % 3;
            sb.append(binaryDigits[i]);
        }

        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
