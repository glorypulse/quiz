class Solution {
    int MAX = 255;
    int MIN = 0;
    public double[] sampleStats(int[] count) {
        int min = MAX + 1;
        int max = MIN - 1;
        int mode = -1;
        int mode_num = -1;
        long sum = 0, sum_count = 0;
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            if (num == 0) continue;
            if (min > i) { min = i; }
            if (max < i) { max = i; }
            if (mode_num < num) {
                mode_num = num;
                mode = i;
            }

            sum += i * num;
            sum_count += num;
        }

        double median = 0.0;
        long half = sum_count / 2;
        int sum_count2 = 0;
        int median_sum = -1;
        for(int i = 0; i < count.length; i++) {
            int num = count[i];
            if (num == 0) continue;
            sum_count2 += num;
            if (sum_count2 > half) {
                if (median_sum >= 0) {
                    median = (double)(median_sum + i) / 2.0;
                } else {
                    median = (double)i;
                }
                break;
            } else if (sum_count2 == half) {
                if (sum_count % 2 == 0) {
                    // even
                    median_sum = i;
                } else {
                    // odd
                    median = (double)i;
                    break;
                }
            }
        }

        double[] ret = {(double)min, (double)max, (double)sum / (double)sum_count, median, (double)mode };
        return ret;
    }
}
