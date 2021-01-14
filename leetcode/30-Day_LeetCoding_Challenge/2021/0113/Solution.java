class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] counts = new int[limit + 1];
        for (int weight: people) {
            counts[weight] ++;
        }
        int count = 0;
        for (int weight = limit; weight >= 1; weight --) {
            int target = Math.min(limit - weight, weight);
            while (counts[weight] > 0) {
                count ++;
                counts[weight] --;
                while (target >= 0) {
                    if (counts[target] > 0) {
                        counts[target] --;
                        break;
                    } else {
                        target --;
                    }
                }
            }
        }
        return count;
    }
}
