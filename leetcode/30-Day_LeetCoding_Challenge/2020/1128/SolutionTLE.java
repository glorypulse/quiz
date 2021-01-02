class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length; // 1 <= k <= length
        int[] ans = new int[length - k + 1];

        LinkedList<Integer> pQueue = new LinkedList<>();
        pQueue.add(nums[0]);
        for (int i = 1; i < k; i ++) {
            int j = 0;
            int num = nums[i];
            for (int n: pQueue) {
                if (num > n) break;
                j ++;
            }
            if (j < pQueue.size()) {
                pQueue.add(j, num);
            } else {
                pQueue.add(num);
            }
        }
        ans[0] = pQueue.peek();
        for (int i = k; i < length; i ++) {
            int j = 0;
            for (int n :pQueue) {
                if (nums[i - k] == n) break;
                j ++;
            }
            pQueue.remove(j);

            j = 0;
            for (int n: pQueue) {
                if (nums[i] > n) break;
                j ++;
            }
            if (j < pQueue.size()) {
                pQueue.add(j, nums[i]);
            } else {
                pQueue.add(nums[i]);
            }
            ans[i - k + 1] = pQueue.peek();
        }
        return ans;
    }
}
