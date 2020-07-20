class Solution {
    public int[] plusOne(int[] digits) {
      for (int i = digits.length - 1; i >= 0; i --) {
        int value = digits[i] + 1;
        if (value <= 9) {
          digits[i] = value;
          return digits;
        } else {
          if (i > 0) {
            digits[i] = 0;
          } else {
            int[] plusDigits = new int[digits.length + 1];
            Arrays.fill(plusDigits, 0;
            plusDigits[0] = 1;
            return plusDigits;
          }
        }
      }
      return digits;
    }
}