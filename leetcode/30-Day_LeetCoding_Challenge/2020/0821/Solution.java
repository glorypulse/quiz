class Solution {
    public int[] sortArrayByParity(int[] A) {
        int even = 0;
        int odd = A.length - 1;
        while (even < odd) {
            while (even < A.length && A[even] % 2 == 0) even ++;
            while (odd >= 0 && A[odd] % 2 != 0) odd --;
            if (even >= odd) break;
            int tmp = A[even];
            A[even] = A[odd];
            A[odd] = tmp;
        }
        return A;
    }
}
