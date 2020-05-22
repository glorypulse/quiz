class Solution {
    public String frequencySort(String s) {
        int[] countChar = new int['z' - ' ' + 1];
        for (char c: s.toCharArray()) {
            countChar[c - ' '] ++;
        }
        int[][] freqChar = new int[s.length()][2];
        int index = 0;
        for (int i = 0; i < countChar.length; i ++) {
            if (countChar[i] == 0) continue;
            freqChar[index][0] = countChar[i];
            freqChar[index][1] = i;
            index ++;
        }

        Arrays.sort(freqChar, (a, b) -> b[0] - a[0]);
        StringBuilder sb = new StringBuilder();
        for (int[] freq : freqChar) {
            if (freq[0] == 0) break;
            char c = (char)(freq[1] + ' ');
            for (int i = 0; i < freq[0]; i ++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
