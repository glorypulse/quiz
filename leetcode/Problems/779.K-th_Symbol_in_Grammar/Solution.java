class Solution {
    public int kthGrammar(int N, int K) {
        if (K == 1) return 0;
        if (K == 2) return 1;
        if (K % 2 == 0) {
            if (kthGrammar(N - 1, (K + 1) / 2) == 0) return 1;
            else return 0;
        }
        return kthGrammar(N - 1, (K + 1) / 2);
    }
}
