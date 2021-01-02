class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        int h = 0;
        Arrays.sort(citations);
        while (left <= right) {
            int index = (left + right) / 2;
            h = Math.max(Math.min(n - index, citations[index]), h);
            if (n - index < citations[index]) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return h;
    }
}
