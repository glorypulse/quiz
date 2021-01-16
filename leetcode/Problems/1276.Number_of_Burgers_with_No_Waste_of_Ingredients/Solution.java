import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int total_jumbo, total_small;
        List<Integer> totalList = new ArrayList<>();
        total_jumbo = tomatoSlices - 2 * cheeseSlices;
        if (total_jumbo < 0 || total_jumbo % 2 != 0) {
            return totalList;
        }
        total_jumbo /= 2;

        total_small = cheeseSlices - total_jumbo;
        if (total_small < 0) {
            return totalList;
        }

        if (tomatoSlices != 4 * total_jumbo + 2 * total_small) {
            return totalList;
        }

        totalList.add(total_jumbo);
        totalList.add(total_small);
        return totalList;
    }
}
