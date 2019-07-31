class Solution {
    public boolean judgeCircle(String moves) {
        int countRight = 0;
        int countUp = 0;
        for (char c: moves.toCharArray()) {
            switch(c) {
            case 'U':
                countUp ++;
                break;
            case 'D':
                countUp --;
                break;
            case 'R':
                countRight ++;
                break;
            case 'L':
                countRight --;
                break;
            }
        }
        if (countRight == 0 && countUp == 0) {
            return true;
        }
        return false;
    }
}
