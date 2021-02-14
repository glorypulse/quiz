class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num > 1) {
            if ((num & 1) > 0) count ++;
            count ++;
            num >>= 1;
        }
        if ((num & 1) > 0) count ++;
        return count;
    }
}
