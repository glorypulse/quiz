import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        for (int num1: nums1) {
            numSet.add(num1);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int num2: nums2) {
            if (numSet.contains(num2)) {
                resultSet.add(num2);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int res: resultSet) {
            result[i] = res;
            i ++;
        }
        return result;
    }
}
