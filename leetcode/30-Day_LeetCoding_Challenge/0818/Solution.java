class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> found = new ArrayList<>();
        if (N == 1) {
            found.add(0);
        }
        for (int i = 1; i <= 9; i ++) {
            makeDigitDiffK(found, "", i, N, K);
        }

        int[] nums = new int[found.size()];
        int i = 0;
        for (int num: found) {
            nums[i] = num;
            i ++;
        }
        return nums;
    }

    void makeDigitDiffK(List<Integer> found, String num, int digit, int n, int k) {
        if (digit < 0 || digit > 9) return;
        if (n == 1) {
            found.add(Integer.parseInt(num + digit));
            return;
        }
        if (k == 0) {
            makeDigitDiffK(found, num + digit, digit, n - 1, k);
        } else {
            makeDigitDiffK(found, num + digit, digit - k, n - 1, k);
            makeDigitDiffK(found, num + digit, digit + k, n - 1, k);
        }
    }

}
