class Solution {
    int checkPerformance(int total, int lower, int upper) {
        if (total < lower) {
            return -1;
        } else if (total > upper) {
            return 1;
        }
        return 0;
    }

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int length = calories.length;
        int total = 0;
        int point = 0;
        for (int i = 0; i < length; i ++) {
            total += calories[i];
            if (i >= k) {
                total -= calories[i - k];
            }
            if (i >= k - 1) {
                point += checkPerformance(total, lower, upper);
            }
        }

        return point;
    }
}
