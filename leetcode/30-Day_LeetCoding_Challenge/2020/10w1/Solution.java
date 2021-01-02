class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int[][] max = new int[][] { { -1, Integer.MIN_VALUE }, { -1, Integer.MIN_VALUE } };
        int[][] min = new int[][] { { -1, Integer.MAX_VALUE }, { -1, Integer.MAX_VALUE } };

        int i = 0;
        for (List<Integer> array: arrays) {
            int size = array.size();
            int currentMin = array.get(0);
            int currentMax = array.get(size - 1);
            if (min[0][1] >= currentMin) {
                min[1][0] = min[0][0];
                min[1][1] = min[0][1];
                min[0][0] = i;
                min[0][1] = currentMin;
            } else if (min[1][1] > currentMin) {
                min[1][0] = i;
                min[1][1] = currentMin;
            }

            if (max[0][1] <= currentMax) {
                max[1][0] = max[0][0];
                max[1][1] = max[0][1];
                max[0][0] = i;
                max[0][1] = currentMax;
            } else if (max[1][1] < currentMax) {
                max[1][0] = i;
                max[1][1] = currentMax;
            }
            i ++;
        }

        if (max[0][0] != min[0][0]) {
            return Math.abs(max[0][1] - min[0][1]);
        } else {
            return Math.max(Math.abs(max[1][1] - min[0][1]), Math.abs(max[0][1] - min[1][1]));
        }

    }
}
