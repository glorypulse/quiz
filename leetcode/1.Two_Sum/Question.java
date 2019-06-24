import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // number => [indexes]
        HashMap<Integer, ArrayList<Integer>> numsMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ArrayList<Integer> indexes = numsMap.get(num);
            if (indexes == null) {
                indexes = new ArrayList<Integer>();
                numsMap.put(num, indexes);
            }
            indexes.add(i);
        }

        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ArrayList<Integer> indexes = numsMap.get(num);
            indexes.remove(Integer.valueOf(i));
            indexes = numsMap.get(target - num);
            if (indexes != null && !indexes.isEmpty()) {
                ret[0] = i;
                ret[1] = indexes.get(0);
                break;
            }
        }

        return ret;
    }
}
