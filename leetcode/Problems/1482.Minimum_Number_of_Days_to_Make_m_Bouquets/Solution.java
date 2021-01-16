class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int flower_num = bloomDay.length;
        if (flower_num < m * k) return -1;

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int day: bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int left = min;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            int bloom = 0;
            int bouquet = 0;
            for (int i = 0; i < flower_num; i ++) {
                if (bloomDay[i] <= mid) {
                    bloom ++;
                } else {
                    bloom = 0;
                }

                if (bloom == k) {
                    bouquet ++;
                    bloom = 0;
                }
            }

            if (bouquet < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
