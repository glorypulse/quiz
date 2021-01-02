class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int s = lower;
        int length = nums.length;
        int i = 0;
        List<String> missingRanges = new ArrayList<>();

        while (s <= upper && i < length) {
            int r = nums[i];
            addMissingRanges(s, r - 1, missingRanges);
            s = r + 1;
            i ++;
        }

        addMissingRanges(s, upper, missingRanges);
        return missingRanges;
    }

    void addMissingRanges(int s, int upper, List<String> missingRanges) {
        if (s < upper) {
            missingRanges.add(s + "->" + upper);
        } else if (s == upper) {
            missingRanges.add(String.valueOf(s));
        }
    }
}
