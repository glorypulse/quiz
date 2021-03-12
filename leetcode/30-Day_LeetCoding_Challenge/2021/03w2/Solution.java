class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            switch (leftChar) {
            case '0':
            case '1':
            case '8':
                if (leftChar != rightChar) return false;
                break;
            case '6':
                if (rightChar != '9') return false;
                break;
            case '9':
                if (rightChar != '6') return false;
                break;
            default:
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
