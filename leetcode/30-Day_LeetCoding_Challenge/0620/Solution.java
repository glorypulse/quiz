class Solution {
    public String getPermutation(int n, int k) {
        int perNum = 1;
        LinkedList<Integer> digits = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            perNum *= i;
            digits.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i --) {
            perNum /= i;
            int index = getDigit(i, perNum, k);
            int num = digits.remove(index);
            sb.append(num);
            k -= index * perNum;
        }
        return sb.toString();
    }

    int getDigit(int n, int perNum, int k) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mid * perNum;
            if (k <= val) {
                if (val - perNum < k) return mid - 1;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
