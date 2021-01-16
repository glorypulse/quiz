import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        HashSet<Integer> numsSet = new HashSet<Integer>();
        for (int num: nums) {
            numsSet.add(num);
        }
        permuteTree(permutations, new LinkedList<Integer>(), numsSet);
        return permutations;
    }

    public void permuteTree(List<List<Integer>> permutations, LinkedList<Integer> ancestors, HashSet<Integer> nums) {
        if (nums.size() == 1) {
            for (int num: nums) {
                ancestors.add(num);
                permutations.add(new ArrayList<Integer>(ancestors));
                ancestors.removeLast();
            }
            return;
        }

        HashSet<Integer> numsClone = new HashSet<Integer>(nums);
        for (int num: nums) {
            numsClone.remove(num);
            ancestors.add(num);
            permuteTree(permutations, ancestors, numsClone);
            ancestors.removeLast();
            numsClone.add(num);
        }
        return;
    }
}
