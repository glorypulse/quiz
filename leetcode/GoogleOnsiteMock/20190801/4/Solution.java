class Solution {
    double calcMinCost(int index, int[] quality, int[] wage, int k, double[] nowWage, boolean[] paid) {
        if (wage.length - index < k) {
            return Integer.MAX_VALUE + 1.0;
        }
        if (k == 0) {
            double sum = 0.0;
            for (int i = 0; i < index; i ++) {
                if (paid[i]) {
                    sum += nowWage[i];
                }
            }
            return sum;
        }

        double minCostOn = Double.MAX_VALUE;
        double[] onWage;
        // 入れる
        if (wage[index] > nowWage[index]) {
            onWage = new double[wage.length];
            setWage(index, quality, wage, onWage);
        } else {
            onWage = nowWage;
        }
        paid[index] = true;
        minCostOn = calcMinCost(index + 1, quality, wage, k - 1, onWage, paid);

        // 入れない
        double minCostOff = Double.MAX_VALUE;
        if (wage.length - index > k) {
            paid[index] = false;
            minCostOff = calcMinCost(index + 1, quality, wage, k, nowWage, paid);
        }

        return Math.min(minCostOn, minCostOff);
    }

    void setWage(int index, int[] quality, int[] wage, double[] nowWage) {
        nowWage[index] = wage[index];
        for (int i = 0; i < wage.length; i ++) {
            if (i == index) continue;
            nowWage[i] = 1.0 * nowWage[index] * quality[i] / quality[index];
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[] nowWage = new double[wage.length];
        boolean[] paid = new boolean[wage.length];
        double minCost = calcMinCost(0, quality, wage, K, nowWage, paid);
        return minCost;
    }
}
