class Solution {
    public boolean checkValidString(String s) {
        int astarisk = 0;
        int count = 0;

        int reverse_astarisk = 0;
        int reverse_count = 0;
        int length = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length; i ++) {
            char c = charArray[i];
            switch (c) {
            case '(':
                count ++;
                break;
            case ')':
                if (count > 0) {
                    count --;
                } else if (astarisk > 0) {
                    astarisk --;
                } else {
                    return false;
                }
                break;
            case '*':
                astarisk ++;
                break;
            }

            char revC = charArray[length - 1 - i];
            switch (revC) {
            case ')':
                reverse_count ++;
                break;
            case '(':
                if (reverse_count > 0) {
                    reverse_count --;
                } else if (reverse_astarisk > 0) {
                    reverse_astarisk --;
                } else {
                    return false;
                }
                break;
            case '*':
                reverse_astarisk ++;
                break;
            }
        }
        return true;
    }
}
