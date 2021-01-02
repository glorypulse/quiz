class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K == 1) return 1;
        int len = 1;
        int remainder = 1;
        Set<Integer> remainderSet = new HashSet<>();
        remainderSet.add(0);
        while (!remainderSet.contains(remainder)) {
            len ++;
            remainderSet.add(remainder);
            remainder = (remainder * 10 + 1) % K;
        }
        if (remainder != 0) return -1;
        return len;
    }
}
