class Solution {
    public int maxProduct(int[] nums) {
        int max = 0, next_max = 0;
        for (int num: nums) {
            if (max < num) {
                next_max = max;
                max = num;
            } else if (next_max < num) {
                next_max = num;
            }
        }

        return (max - 1) * (next_max - 1);
    }
}
