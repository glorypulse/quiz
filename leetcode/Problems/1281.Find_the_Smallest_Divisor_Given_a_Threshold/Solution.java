class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        int target, result;
        while (left <= right) {
            target = (left + right) / 2;
            result = divideArray(nums, target);
            if (result == threshold) {
                while (target > 1 && divideArray(nums, target - 1) == threshold) target --;
                return target;
            } else if (result < threshold) {
                if (target == 1 || divideArray(nums, target - 1) > threshold) {
                    return target;
                }
                right = target - 1;
            } else {
                left = target + 1;
            }
        }

        // ここにはこない想定
        return left;
    }

    int divideArray(int[] nums, int target) {
        int sum = 0;
        int tmp;
        for (int num: nums) {
            tmp = num / target;
            sum += tmp;
            if (tmp * target < num) {
                sum += 1;
            }
        }
        System.out.println("target:" + target + ",result:" + sum);
        return sum;
    }
}
