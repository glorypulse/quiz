class Solution {
    public String getSmallestString(int n, int k) {
        char[] smallestCharArray = new char[n];
        int value = k;
        for (int i = n - 1; i >= 0; i --) {
            char current = 'z';
            if (value - i < 26) {
                current = (char)('a' + value - i - 1);
            }
            value -= current - 'a' + 1;
            smallestCharArray[i] = current;
        }
        return new String(smallestCharArray);
    }
}
