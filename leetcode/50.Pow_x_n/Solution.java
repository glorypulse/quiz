class Solution {
    public double myPow(double x, int n) {
        return myPowLong(x, n);
    }

    double myPowLong(double x, long n) {
        if (x == 0.0) return 0.0;
        if (n == 0 || x == 1.0) return 1.0;
        if (n < 0) return myPowLong(1 / x, -n);
        if (n % 2 != 0) return myPowLong(x, n - 1) * x;

        double x2 = myPowLong(x, n / 2);
        return x2 * x2;
    }
}
