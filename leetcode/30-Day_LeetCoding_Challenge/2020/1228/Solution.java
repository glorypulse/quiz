class Solution {
    public int reachNumber(int target) {
        int k = 0;
        int sum = 0;
        if (target < 0) {
            target = -target;
        }
        while (sum < target) {
            k ++;
            sum += k;
        }

        while ((sum - target) % 2 != 0) {
            k ++;
            sum += k;
        }
        return k;
    }
}
