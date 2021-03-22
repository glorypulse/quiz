class Solution {
    public boolean reorderedPowerOf2(int N) {
        if (N == 0) return false;
        String nStr = String.valueOf(N);
        int length = nStr.length();
        int max = (int)Math.pow(10, length);
        if (max == N) return false;
        int min = max / 10;
        long powerOf2 = 1;
        Set<Integer> targetSet = new HashSet<>();
        while (powerOf2 < max) {
            if (powerOf2 >= min) {
                targetSet.add((int)powerOf2);
            }
            powerOf2 <<= 1;
        }

        int[] counts = new int[10];
        for (char c: nStr.toCharArray()) {
            counts[c - '0'] ++;
        }

        for (int target: targetSet) {
            if (canMake(target, counts)) return true;
        }
        return false;
    }

    boolean canMake(int target, int[] counts) {
        if (target == 0) return true;
        int d = target % 10;
        if (counts[d] > 0) {
            counts[d] --;
            if (canMake(target / 10, counts)) return true;
            counts[d] ++;
        }
        return false;
    }
}
