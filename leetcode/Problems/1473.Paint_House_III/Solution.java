class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][] neighborsCost = new int[target + 1][n];
        int[][] mins = new int[target + 1][];

        for (int i = 0; i < target + 1; i ++) {
            for (int j = 0; j < n; j ++) {
                neighborsCost[i][j] = Integer.MAX_VALUE;
            }
        }

        // initialize
        if (houses[0] == 0) {
            for (int j = 0; j < n; j ++) {
                neighborsCost[target - 1][j] = cost[0][j];
            }
        } else {
            for (int j = 0; j < n; j ++) {
                if (houses[0] == j + 1) {
                    neighborsCost[target - 1][j] = 0;
                } else {
                    neighborsCost[target - 1][j] = Integer.MAX_VALUE;
                }
            }
        }
        mins[target] = new int[] { -1, Integer.MAX_VALUE, Integer.MAX_VALUE };
        mins[target - 1] = minSet(neighborsCost[target - 1]);

        for (int h = 1; h < houses.length; h ++) {
            int house = houses[h];
            for (int i = Math.max(0, target - h - 1); i < target; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (house == 0) {
                        neighborsCost[i][j] = Math.min(neighborsCost[i][j], j != mins[i + 1][0] ? mins[i + 1][1] : mins[i + 1][2]);
                        if (neighborsCost[i][j] < Integer.MAX_VALUE) {
                            neighborsCost[i][j] += cost[h][j];
                        }
                    } else if (house == j + 1) {
                        neighborsCost[i][j] = Math.min(neighborsCost[i][j], j != mins[i + 1][0] ? mins[i + 1][1] : mins[i + 1][2]);
                    } else {
                        neighborsCost[i][j] = Integer.MAX_VALUE;
                    }
                }
                mins[i] = minSet(neighborsCost[i]);
            }

        }

        if (mins[0][1] == Integer.MAX_VALUE) return -1;
        return mins[0][1];
    }

    int[] minSet(int[] costArray) {
        int min = Integer.MAX_VALUE, minNext = Integer.MAX_VALUE, minIndex = -1;
        int n = costArray.length;

        for (int j = 0; j < n; j ++) {
            if (min > costArray[j]) {
                minNext = min;
                min = costArray[j];
                minIndex = j;
            } else if (minNext > costArray[j]) {
                minNext = costArray[j];
            }
        }
        return new int[] { minIndex, min, minNext };
    }
}
