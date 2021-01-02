class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_index = 0, t_index = 0;
        while (s_index < s.length() && t_index < t.length()) {
            char c_s = s.charAt(s_index);
            char t_s = t.charAt(t_index);

            if (c_s == t_s) {
                s_index ++;
                t_index ++;
            } else {
                t_index ++;
            }
        }

        if (s_index == s.length()) return true;
        return false;
    }
}
