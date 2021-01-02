class Solution {
    public int[] plusOne(int[] digits) {
      int value = 0;
      for (int digit: digits) {
        value = value * 10 + digit;
      }
      value ++;
      String valueStr = String.valueOf(value);
      int[] plusDigits = new int[valueStr.length()];
      
      for (int i = 0; i < plusDigits.length; i ++) {
        plusDigits[i] = valueStr.charAt(i) - '0';
      }
      
      return plusDigits;
    }
}