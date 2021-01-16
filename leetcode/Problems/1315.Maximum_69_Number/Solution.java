class Solution {
    public int maximum69Number (int num) {
        String numStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        boolean changed = false;

        for (char numChar: numStr.toCharArray()) {
            if (numChar == '9') {
                sb.append(numChar);
                continue;
            }
            if (!changed) {
                sb.append('9');
                changed = true;
            } else {
                sb.append(numChar);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
