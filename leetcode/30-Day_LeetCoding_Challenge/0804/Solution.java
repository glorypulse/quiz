class Solution {
    public boolean isPowerOfFour(int num) {
        String binary = Integer.toBinaryString(num);
        int digit = binary.length();
        if (digit % 2 == 0 ||
            binary.substring(1).contains("1") ||
            num == 0) {
            return false;
        }
        return true;
    }
}
