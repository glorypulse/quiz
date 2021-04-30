class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        ArrayList<Integer> powerX = new ArrayList<>();
        ArrayList<Integer> powerY = new ArrayList<>();
        powerX.add(1);
        powerY.add(1);
        int tmp = x;
        if (tmp != 1) {
            while (tmp < bound) {
                powerX.add(tmp);
                tmp *= x;
            }
        }
        tmp = y;
        if (tmp != 1) {
            while (tmp < bound) {
                powerY.add(tmp);
                tmp *= y;
            }
        }
        Set<Integer> powerfulNums = new HashSet<>();
        for (int i = 0; i < powerX.size(); i ++) {
            x = powerX.get(i);
            for (int j = 0; j < powerY.size(); j ++) {
                int val = x + powerY.get(j);
                if (val <= bound) {
                    powerfulNums.add(val);
                } else {
                    break;
                }
            }
        }
        return new ArrayList<Integer>(powerfulNums);
    }
}
