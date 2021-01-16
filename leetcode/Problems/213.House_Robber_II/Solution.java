class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 3) {
            int max = 0;
            for (int num: nums) {
                if (max < num) max = num;
            }
            return max;
        }

        int[] on_last_on = new int[nums.length];
        int[] off_last_on = new int[nums.length];
        int[] on_last_off = new int[nums.length];
        int[] off_last_off = new int[nums.length];
        on_last_on[0] = off_last_on[0] = nums[0];
        on_last_off[0] = off_last_off[0] = 0;
        on_last_on[1] = on_last_on[0];
        off_last_on[1] = off_last_on[0];
        on_last_off[1] = on_last_off[0] + nums[1];
        off_last_off[1] = off_last_off[0];

        for (int i = 2; i < nums.length; i ++) {
            on_last_on[i] = off_last_on[i - 1] + nums[i];
            off_last_on[i] = Math.max(on_last_on[i - 1], off_last_on[i - 1]);
            on_last_off[i] = off_last_off[i - 1] + nums[i];
            off_last_off[i] = Math.max(on_last_off[i - 1], off_last_off[i - 1]);
        }

        int[] max_nums = { off_last_on[nums.length - 1], on_last_off[nums.length - 1], off_last_off[nums.length - 1] };
        int max = 0;
        for (int max_num: max_nums) {
            System.out.println(max_num);
            if (max < max_num) max = max_num;
        }

        return max;
    }
}
