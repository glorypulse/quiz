class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int digit;
        while (n > 0) {
            digit = n - (n / 10 * 10);
            product *= digit;
            sum += digit;
            n /= 10;
        }

        return product - sum;
    }
}
