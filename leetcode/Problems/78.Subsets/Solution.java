import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        LinkedList<Integer> numsList = new LinkedList<>();
        for (int num: nums) {
            numsList.add(num);
        }
        storeSubsets(new LinkedList<Integer>(), numsList, ret);
        return ret;
    }

    void storeSubsets(LinkedList<Integer> list, LinkedList<Integer> nums, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(list));
        if (nums.size() == 0) return;

        LinkedList<Integer> numsClone = new LinkedList<Integer>(nums);
        while (!numsClone.isEmpty()) {
            list.add(numsClone.poll());
            storeSubsets(list, numsClone, ret);
            list.removeLast();
        }
    }
}
