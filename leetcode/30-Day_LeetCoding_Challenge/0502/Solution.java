class Solution {
    public int numJewelsInStones(String J, String S) {
        char fc = 'A';
        boolean[] jewels = new boolean['z' - fc + 1];
        for (char j: J.toCharArray()) {
            jewels[j - fc] = true;
        }

        int count = 0;
        for (char s: S.toCharArray()) {
            if (jewels[s - fc]) count ++;
        }

        return count;
    }
}
