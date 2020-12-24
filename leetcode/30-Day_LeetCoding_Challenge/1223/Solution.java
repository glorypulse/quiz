class Solution {
    public int nextGreaterElement(int n) {
        int length = 0;
        int tmp = n;
        while (tmp > 0) {
            tmp /= 10;
            length ++;
        }
        if (length <= 1) return -1;

        int[] digits = new int[length];
        tmp = n;
        for (int i = 0; i < length; i ++) {
            digits[i] = tmp % 10;
            if (i == length - 1) break;
            tmp /= 10;
            int next = greaterElement(digits[i], Arrays.copyOfRange(digits, 0, i + 1));
            if (next > 0) {
                long ans = tmp * (long)Math.pow(10, i + 1) + next;
                if (ans > Integer.MAX_VALUE) return -1;
                return (int)ans;
            }
        }
        return greaterElement(digits[length - 1], digits);
    }

    int greaterElement(int targetDigit, int[] digits) {
        int length = digits.length;
        if (length <= 1) return -1;
        Arrays.sort(digits);
        int targetIndex = (length - 1) / 2;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            targetIndex = (left + right) / 2;
            if (targetDigit == digits[targetIndex]) {
                break;
            } else if (targetDigit < digits[targetIndex]) {
                right = targetIndex - 1;
            } else {
                left = targetIndex + 1;
            }
        }
        while (targetIndex < length && targetDigit == digits[targetIndex]) targetIndex ++;
        if (targetIndex == length) return -1;
        long ans = digits[targetIndex];
        for (int i = 0; i < length; i ++) {
            if (i == targetIndex) continue;
            ans = ans * 10 + digits[i];
        }
        if (ans > Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
}
