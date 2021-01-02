class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        if (index == length) return sb.toString();

        while (index < length) {
            char c = s.charAt(index ++);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= '1' && c <= '9') {
                int i = index;
                while (i < length) {
                    char ci = s.charAt(i);
                    if (ci == '[') break;
                    i ++;
                }
                int k = Integer.parseInt(s.substring(index - 1, i));
                index = i + 1;
                String str = decodeString(s);
                for (i = 0; i < k; i ++) {
                    sb.append(str);
                }
            } else if (c == ']') {
                break;
            }
        }
        return sb.toString();
    }
}
