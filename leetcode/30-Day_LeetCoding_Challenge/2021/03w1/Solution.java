class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] keyMap = new int[26];
        for (int i = 0; i < 26; i ++) {
            keyMap[keyboard.charAt(i) - 'a'] = i;
        }
        int distance = 0;
        int current = 0;
        for (char c: word.toCharArray()) {
            int next = keyMap[c - 'a'];
            distance += Math.abs(next - current);
            current = next;
        }
        return distance;
    }
}
