class Solution {
    char ZERO = '0';
    public boolean isHappy(int n) {
        Set<Integer> numSet = new HashSet<>();
        int sum = n;
        while (true) {
            sum = getSumDigit(sum);
            if (sum == 1) return true;
            if (numSet.contains(sum)) return false;
            numSet.add(sum);
        }
    }

    int getSumDigit(int n) {
        int digit, sum = 0;
        for (char c: String.valueOf(n).toCharArray()) {
            digit = c - ZERO;
            sum += digit * digit;
        }
        return sum;
    }
}
