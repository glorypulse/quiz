class Solution {
    public int numSteps(String s) {
        int up = 0;
        char[] sCharArray = s.toCharArray();
        int count = 0;
        for (int i = s.length() - 1; i > 0; i --) {
            int val = sCharArray[i] - '0' + up;
            switch(val) {
            case 0:
                count ++;
                up = 0;
                break;
            case 1:
                count += 2;
                up = 1;
                break;
            case 2:
                count ++;
                up = 1;
                break;
            }
        }
        if (up != 0) count ++;
        return count;
    }
}
