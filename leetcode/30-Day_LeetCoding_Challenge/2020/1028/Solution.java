class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        if (length == 0) return new ArrayList<>();

        ArrayList<int[]> rangeList = new ArrayList<>();
        rangeList.add(new int[]{ nums[0], nums[0] });
        int expect = nums[0] + 1;
        for (int i = 1; i < length; i ++) {
            int num = nums[i];
            if (expect == num) {
                int[] range = rangeList.get(rangeList.size() - 1);
                range[1] = num;
                expect ++;
            } else {
                rangeList.add(new int[]{ num, num });
                expect = num + 1;
            }
        }

        List<String> ansList = new ArrayList<>();
        for (int[] range: rangeList) {
            if (range[0] == range[1]) {
                ansList.add(String.valueOf(range[0]));
            } else {
                ansList.add(range[0] + "->" + range[1]);
            }
        }
        return ansList;
    }
}
