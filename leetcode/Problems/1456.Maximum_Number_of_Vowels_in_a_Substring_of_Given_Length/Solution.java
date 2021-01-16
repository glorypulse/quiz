class Solution {
    final String VOWELS = "aeiuo";
    public int maxVowels(String s, int k) {
        int i = 0;
        char[] charArray = s.toCharArray();
        int count = 0;
        while (i < k) {
            if (VOWELS.indexOf(charArray[i]) >= 0) count ++;
            i ++;
        }
        int max = count;

        while (i < charArray.length) {
            if (VOWELS.indexOf(charArray[i - k]) >= 0) count --;
            if (VOWELS.indexOf(charArray[i]) >= 0) count ++;
            max = Math.max(max, count);
            i ++;
        }

        return max;
    }
}
