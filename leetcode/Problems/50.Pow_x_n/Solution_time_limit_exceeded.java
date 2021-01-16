import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        // 整数部と指数部に分ける
        int xInt = (int)x;
        int ten_times = 0;
        if (xInt != x) {
            // 丸め誤差を出さないようにBigDecimal
            BigDecimal xBD = new BigDecimal(String.valueOf(x));
            for (ten_times = 1; ten_times <= 5; ten_times++) {
                xBD = xBD.scaleByPowerOfTen(1);
                xInt = xBD.intValue();
                if (xBD.compareTo(new BigDecimal(String.valueOf(xInt))) == 0) break;
            }
        }

        int times = n;
        if (times < 0) times = -times;

        // 整数部
        if (xInt < 0) xInt = -xInt;
        BigInteger signedPowInt = calc_signed_pow(new BigInteger(String.valueOf(xInt)), times);

        // 指数部
        ten_times *= times;

        BigDecimal signedPow = new BigDecimal(signedPowInt.toString()).scaleByPowerOfTen(-ten_times);
        System.out.println("Decimal: " + signedPow);

        double ans;
        if (n > 0) {
            ans = signedPow.doubleValue();
        } else {
            ans = new BigDecimal("1.0").divide(signedPow, 5, RoundingMode.HALF_UP).doubleValue();
        }

        if (x < 0 && n % 2 == 1) ans = -ans;
        return ans;
    }

    private BigInteger calc_signed_pow(BigInteger x, int times) {
        if (times == 0) return BigInteger.ONE;
        if (times == 1 || x.equals(BigInteger.ONE) || x.equals(BigInteger.ZERO)) return x;
        if (times % 2 == 0) {
            return calc_signed_pow(x.multiply(x), times / 2);
        } else {
            return x.multiply(calc_signed_pow(x, times - 1));
        }
    }
}
