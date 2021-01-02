class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numsCount = new HashMap<>();
        int check = nums.length / 2;
        for (int num: nums) {
            int count = numsCount.getOrDefault(num, 0);
            count ++;
            if (count > check) {
                return num;
            }
            numsCount.put(num, count);
        }

        return -1;
    }
}
