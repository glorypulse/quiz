class Solution {
    public boolean isIdealPermutation(int[] A) {
        int length = A.length;
        int inversion = 0;
        TreeSet<Integer> remains = new TreeSet<>();
        for (int i = 0; i < length; i ++) {
            remains.add(i);
        }


        for (int i = 0; i < length - 1; i ++) {
            if (A[i] > A[i + 1]) {
                inversion ++;
            }
            remains.remove(A[i]);
            inversion -= remains.headSet(A[i]).size();
        }
        return inversion == 0;
    }
}
