class Solution {
    public int countVowelStrings(int n) {
        int[] counts = new int[5];
        Arrays.fill(counts, 1);
        for (int i = 1; i < n; i ++) {
            for (int j = 3; j >= 0; j --) {
                counts[j] += counts[j + 1];
            }
        }
        int count = 0;
        for (int i = 0; i < 5; i ++) {
            count += counts[i];
        }
        return count;
    }
}
