class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if (length == 0) return -1;
        int s = 0, t = 1 % length;
        int currentCost = gas[s] - cost[s];
        while (s != t) {
            if (currentCost >= 0) {
                currentCost += gas[t] - cost[t];
                t = (t + 1) % length;
            }
            if (currentCost < 0) {
                s = s == 0 ? length - 1 : s - 1;
                currentCost += gas[s] - cost[s];
            }
        }
        if (currentCost < 0) return -1;
        return s;
    }
}