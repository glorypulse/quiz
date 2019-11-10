class Solution {
    public int minimumSwap(String s1, String s2) {
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        char c1, c2;
        int x_yCount = 0, y_xCount = 0;
        for (int i = 0; i < s1CharArray.length; i ++ ) {
            c1 = s1CharArray[i];
            c2 = s2CharArray[i];

            if (c1 == c2) continue;
            if (c1 == 'x') {
                x_yCount ++;
            } else {
                y_xCount ++;
            }
        }

        if ((x_yCount + y_xCount) % 2 != 0) {
            return -1;
        }

        int count = 0;
        count += x_yCount / 2;
        count += y_xCount / 2;
        x_yCount = x_yCount % 2;
        count += x_yCount * 2;
        return count;
    }
}
