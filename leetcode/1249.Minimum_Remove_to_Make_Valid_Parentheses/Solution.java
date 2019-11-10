class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int pCount = 0;
        for (char c: s.toCharArray()) {
            switch(c) {
            case '(':
                pCount ++;
                break;
            case ')':
                if (pCount - 1 < 0) {
                    continue;
                }
                pCount --;
                break;
            }
            sb.append(c);
        }

        if (pCount == 0) {
            return sb.toString();
        }

        String tmpString = sb.reverse().toString();
        sb = new StringBuilder();
        for (char c: tmpString.toCharArray()) {
            if (c == '(' && pCount > 0) {
                pCount --;
                continue;
            }
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
