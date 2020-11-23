class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int length = digits.length;
        String nStr = String.valueOf(n);
        int k = nStr.length();
        int sum = 0;
        int count = length;
        for (int i = 0; i < k - 1; i ++) {
            sum += count;
            count *= length;
        }
        int[] digitsInt = new int[length];
        for (int i = 0; i < length; i ++) {
            digitsInt[i] = Integer.parseInt(digits[i]);
        }
        Arrays.sort(digitsInt);
        sum += countNDigit(digitsInt, nStr, k);
        return sum;
    }

    int countNDigit(int[] digits, String nStr, int k) {
        int num = nStr.charAt(0) - '0';
        if (num == 0) return 0;
        int length = digits.length;
        int count = length;
        while (count > 0) {
            if (digits[count - 1] <= num) break;
            count --;
        }
        if (count == 0) return 0;
        if (k == 1) return count;
        int sum = 0;
        if (digits[count - 1] < num || count > 1) {
            sum += (digits[count - 1] < num ? count : count - 1) * Math.pow(length, k - 1);
        }
        if (digits[count - 1] == num) {
            sum += countNDigit(digits, nStr.substring(1), k - 1);
        }
        return sum;
    }
}
