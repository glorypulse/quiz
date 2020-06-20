class Solution {
    public String longestDupSubstring(String S) {
        int length = S.length();
        int left = 1;
        int right = length;
        String ans = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            String substr = rabin_karp_search(S, mid);
            if (substr != null) {
                ans = substr;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


    String rabin_karp_search(String s, int subLength) {
        int length = s.length();
        HashSet<Long> hashSet = new HashSet<>();

        long b = 100_000_007;

        long bm = 1;
        long hash = 0;
        for (int i = 0; i < subLength; i ++) {
            hash = hash * b + (s.charAt(i) - 'a');
            bm = bm * b;
        }
        hashSet.add(hash);

        for (int i = 0; i < length - subLength; i ++) {
            hash = hash * b - (s.charAt(i) - 'a')  * bm + (s.charAt(i + subLength) - 'a');
            if (hashSet.contains(hash)) return s.substring(i + 1, i + subLength + 1);
            hashSet.add(hash);
        }
        return null;
    }
}
