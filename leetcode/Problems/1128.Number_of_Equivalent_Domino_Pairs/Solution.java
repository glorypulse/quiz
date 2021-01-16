import java.util.Map;
import java.util.HashMap;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> dominoMap = new HashMap<>();
        int tmp, count = 0;
        String dStr;
        Integer before;
        int bInt;
        for (int[] domino: dominoes) {
            if (domino[0] > domino[1]) {
                tmp = domino[0];
                domino[0] = domino[1];
                domino[1] = tmp;
            }
            dStr = domino[0] + "," + domino[1];
            before = dominoMap.get(dStr);
            if (before == null) {
                dominoMap.put(dStr, 1);
            } else {
                count += before;
                dominoMap.put(dStr, before + 1);
            }
        }
        return count;
    }
}
