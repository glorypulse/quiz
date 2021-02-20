class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == ')') {
                if (count <= 0) {
                    continue;
                } else {
                    count --;
                }
            } else if (c == '(') {
                count ++;
            }

            sb.append(c);
        }

        s = sb.reverse().toString();
        sb.setLength(0);
        count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                if (count <= 0) {
                    continue;
                } else {
                    count --;
                }
            } else if (c == ')') {
                count ++;
            }

            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
