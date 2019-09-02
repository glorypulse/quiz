import java.util.ArrayList;

class Solution {
    String range(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return start + "->" + end;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> ret = new ArrayList<String>();
        int start = lower;
        for (int num: nums) {
            if (num > start) {
                ret.add(range(start, num - 1));
            }
            if (num == Integer.MAX_VALUE) { return ret; }
            start = num + 1;
        }
        if (upper >= start) {
            ret.add(range(start, upper));
        }
        return ret;
    }
}
