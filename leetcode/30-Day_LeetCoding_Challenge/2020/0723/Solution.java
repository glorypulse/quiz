class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> first = new HashSet<>();
        for (int num: nums) {
            if (first.contains(num)) {
                first.remove(num);
            } else {
                first.add(num);
            }
        }
        int[] singleNumbers = new int[2];
        int i = 0;
        for (int num: first) {
            singleNumbers[i] = num;
            i ++;
        }
        return singleNumbers;
    }
}
