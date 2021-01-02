class Solution {
    public int firstUniqChar(String s) {
        int[] indexArray = new int[26];
        Arrays.fill(indexArray, -1);
        boolean[] nonRepeat = new boolean[26];

        for (int i = 0; i < s.length(); i ++) {
            int index = s.charAt(i) - 'a';
            if (indexArray[index] < 0) {
                nonRepeat[index] = true;
                indexArray[index] = i;
            } else {
                nonRepeat[index] = false;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i ++) {
            if (indexArray[i] >= 0 && nonRepeat[i] && min > indexArray[i]) {
                min = indexArray[i];
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
