class Solution {
    public int totalFruit(int[] tree) {
        int oneType = -1;
        int[] twoTypes = new int[2];
        Arrays.fill(twoTypes, -1);

        int oneCount = 0;
        int twoCount = 0;
        int max = 0;

        for (int type: tree) {
            if (oneType == type) {
                oneCount ++;
                twoCount ++;
            } else {
                if (twoTypes[0] == type || twoTypes[1] == type) {
                    twoCount ++;
                } else {
                    twoTypes[0] = oneType;
                    twoTypes[1] = type;
                    twoCount = oneCount + 1;
                }
                oneType = type;
                oneCount = 1;
            }
            if (max < twoCount) max = twoCount;
        }

        return max;
    }
}
