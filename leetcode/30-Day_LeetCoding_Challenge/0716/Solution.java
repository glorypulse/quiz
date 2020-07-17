class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        if (x == 1.0) return 1.0;
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n > 0) {
            HashMap<Integer, Double> memoMap = new HashMap<>();
            memoMap.put(0, 0.0);
            memoMap.put(1, x);
            return myPowWithMemo(x, n, memoMap);
        } else {
            HashMap<Integer, Double> memoMap = new HashMap<>();
            memoMap.put(0, 0.0);
            memoMap.put(1, x);
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (myPowWithMemo(x, -(n / 2), memoMap) * myPowWithMemo(x, -(n / 2), memoMap));
            }
            return 1.0 / myPowWithMemo(x, -n, memoMap);
        }
    }

    double myPowWithMemo(double x, int n, HashMap<Integer, Double> memoMap) {
        if (memoMap.containsKey(n)) return memoMap.get(n);
        double ans = 0.0;
        if (n % 2 == 0) {
            ans = myPowWithMemo(x, n / 2, memoMap) * myPowWithMemo(x, n / 2, memoMap);
        } else {
            ans = myPowWithMemo(x, n - 1, memoMap) * x;
        }
        memoMap.put(n, ans);
        return ans;
    }
}
