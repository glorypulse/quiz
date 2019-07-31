class Solution {
    public boolean isStrobogrammatic(String num) {
        int length = num.length();
        for (int i = length - 1; i >= 0; i --) {
            switch(num.charAt(i)) {
            case '6':
                if (num.charAt(length - 1 - i) != '9') return false;
                break;
            case '9':
                if (num.charAt(length - 1 - i) != '6') return false;
                break;
            case '8':
                if (num.charAt(length - 1 - i) != '8') return false;
                break;
            case '1':
                if (num.charAt(length - 1 - i) != '1') return false;
                break;
            case '0':
                if (num.charAt(length - 1 - i) != '0') return false;
                break;
            default:
                return false;
            }
        }
        return true;
    }
}
