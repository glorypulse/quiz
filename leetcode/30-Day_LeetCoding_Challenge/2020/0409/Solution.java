class Solution {
    public boolean backspaceCompare(String S, String T) {

        int s_length = S.length();
        int t_length = T.length();
        int i = s_length - 1, j = t_length - 1;
        char s_char, t_char;

        while (i >= 0 || j >= 0) {
            if (i < 0) {
                s_char = ' ';
            } else {
                s_char = S.charAt(i);
            }
            if (j < 0) {
                t_char = ' ';
            } else {
                t_char = T.charAt(j);
            }

            while (s_char == '#') {
                i = getIndex(i, S);
                if (i < 0) {
                    s_char = ' ';
                } else {
                    s_char = S.charAt(i);
                }

            }
            while (t_char == '#') {
                j = getIndex(j, T);
                if (j < 0) {
                    t_char = ' ';
                } else {
                    t_char = T.charAt(j);
                }
            }

            if (s_char != t_char) {
                return false;
            }

            i --;
            j --;
        }
        return true;
    }

    int getIndex(int index, String str) {
        index --;
        if (index < 0) return index;
        char c = str.charAt(index);
        while (c == '#') {
            index = getIndex(index, str);
            if (index < 0) return index;
            c = str.charAt(index);
        }
        index --;
        return index;
    }
}
