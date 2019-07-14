class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int i, max = 0, sum = 0;

        for (int p : weights) {
            sum += p;
            if (max < p) max = p;
        }


        int[] days = new int[D];
        int capacity = max, day = 0, day_sum = 0;
        i = 0;
        while (capacity < sum) {
            while (day < D && i < weights.length) {
                while (day_sum < capacity && i < weights.length) {
                    day_sum += weights[i];
                    i++;
                }
                if (day_sum > capacity) { i--; }

                day ++;
                day_sum = 0;
            }
            if (i == weights.length) return capacity;

            capacity ++;
            day = 0;
            i = 0;
            day_sum = 0;
        }

        return sum;
    }
}
